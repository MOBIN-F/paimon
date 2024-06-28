/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.paimon.flink.action.cdc.format.tidb;

import org.apache.paimon.flink.action.cdc.CdcSourceRecord;
import org.apache.paimon.flink.action.cdc.ComputedColumn;
import org.apache.paimon.flink.action.cdc.TypeMapping;
import org.apache.paimon.flink.action.cdc.format.RecordParser;
import org.apache.paimon.flink.action.cdc.mysql.MySqlTypeUtils;
import org.apache.paimon.flink.sink.cdc.CdcRecord;
import org.apache.paimon.flink.sink.cdc.RichCdcMultiplexRecord;
import org.apache.paimon.types.DataField;
import org.apache.paimon.types.DataType;
import org.apache.paimon.types.RowKind;
import org.apache.paimon.types.RowType;
import org.apache.paimon.utils.JsonSerdeUtil;

import org.apache.paimon.shade.jackson2.com.fasterxml.jackson.core.type.TypeReference;
import org.apache.paimon.shade.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.paimon.shade.jackson2.com.fasterxml.jackson.databind.node.ArrayNode;

import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.apache.paimon.utils.JsonSerdeUtil.getNodeAs;
import static org.apache.paimon.utils.JsonSerdeUtil.isNull;
import static org.apache.paimon.utils.Preconditions.checkArgument;

/** TidbBinlogRecordParser. */
public class TidbBinlogRecordParser extends RecordParser {

    private static final Logger LOG = LoggerFactory.getLogger(TidbBinlogRecordParser.class);

    private static final String FIELD_BEFORE = "old";
    private static final String FIELD_AFTER = "data";
    private static final String FIELD_PRIMARY = "pkNames";
    private static final String FIELD_MYSQL_TYPE = "mysqlType";
    private static final String FIELD_TYPE = "type";
    private static final String OP_UPDATE = "UPDATE";
    private static final String OP_INSERT = "INSERT";
    private static final String OP_DELETE = "DELETE";

    public static final int DELETE_VALUE = 2;
    public static final int UPDATE_VALUE = 1;

    public TidbBinlogRecordParser(
            TypeMapping typeMapping,
            List<ComputedColumn> computedColumns,
            String includingTables,
            String excludingTables) {
        super(typeMapping, computedColumns, includingTables, excludingTables);
        checkArgument(!includingTables.equals(".*"), "includingTables not set '.*'");
    }

    @Override
    protected List<RichCdcMultiplexRecord> extractRecords() {
        List<RichCdcMultiplexRecord> records = new ArrayList<>();
        for (JsonNode jsonNode : root) {
            String operation = jsonNode.get(FIELD_TYPE).asText();
            switch (operation) {
                case OP_INSERT:
                    processRecord(jsonNode, RowKind.INSERT, records);
                    break;
                case OP_UPDATE:
                    processRecord(jsonNode, RowKind.DELETE, records);
                    processRecord(jsonNode, RowKind.INSERT, records);
                    break;
                case OP_DELETE:
                    break;
                default:
                    throw new UnsupportedOperationException(
                            "Unknown record operation: " + operation);
            }
        }
        return records;
    }

    @Override
    protected void processRecord(
            JsonNode jsonNode, RowKind rowKind, List<RichCdcMultiplexRecord> records) {
        RowType.Builder rowTypeBuilder = RowType.builder();
        Map<String, String> rowData = this.extractRowData(jsonNode, rowTypeBuilder, rowKind);
        records.add(createRecord(rowKind, rowData, rowTypeBuilder.build().getFields(), jsonNode));
    }

    private RichCdcMultiplexRecord createRecord(
            RowKind rowKind,
            Map<String, String> data,
            List<DataField> paimonFields,
            JsonNode jsonNode) {
        return new RichCdcMultiplexRecord(
                getDatabaseName(jsonNode),
                getTableName(jsonNode),
                paimonFields,
                extractPrimaryKeys(jsonNode),
                new CdcRecord(rowKind, data));
    }

    @Nullable
    protected String getDatabaseName(JsonNode jsonNode) {
        JsonNode node = jsonNode.get(FIELD_DATABASE);
        return isNull(node) ? null : node.asText();
    }

    @Nullable
    protected String getTableName(JsonNode jsonNode) {
        JsonNode node = jsonNode.get(FIELD_TABLE);
        return isNull(node) ? null : node.asText();
    }

    private List<String> extractPrimaryKeys(JsonNode jsonNode) {
        ArrayNode pkNames = getNodeAs(jsonNode, primaryField(), ArrayNode.class);
        if (pkNames == null) {
            return Collections.emptyList();
        }

        return StreamSupport.stream(pkNames.spliterator(), false)
                .map(JsonNode::asText)
                .collect(Collectors.toList());
    }

    protected Map<String, String> extractRowData(
            JsonNode record, RowType.Builder rowTypeBuilder, RowKind rowKind) {
        LinkedHashMap<String, String> originalFieldTypes = tryExtractOriginalFieldTypes(record);
        Map<String, Object> recordMap =
                JsonSerdeUtil.convertValue(
                        rowKind == RowKind.INSERT
                                ? record.get(FIELD_AFTER)
                                : record.get(FIELD_BEFORE),
                        new TypeReference<Map<String, Object>>() {});
        Map<String, String> rowData = new HashMap<>();

        if (originalFieldTypes != null) {
            for (Map.Entry<String, String> e : originalFieldTypes.entrySet()) {
                String originalName = e.getKey();
                String originalType = e.getValue();
                Tuple3<String, Integer, Integer> typeInfo =
                        MySqlTypeUtils.getTypeInfo(originalType);
                DataType paimonDataType =
                        MySqlTypeUtils.toDataType(
                                typeInfo.f0, typeInfo.f1, typeInfo.f2, typeMapping);
                rowTypeBuilder.field(originalName, paimonDataType);

                String filedValue = Objects.toString(recordMap.get(originalName), null);
                rowData.put(originalName, filedValue);
            }
        } else {
            fillDefaultTypes(record, rowTypeBuilder);
            for (Map.Entry<String, Object> entry : recordMap.entrySet()) {
                rowData.put(entry.getKey(), Objects.toString(entry.getValue(), null));
            }
        }

        evalComputedColumns(rowData, rowTypeBuilder);
        return rowData;
    }

    @Nullable
    private LinkedHashMap<String, String> tryExtractOriginalFieldTypes(JsonNode data) {
        JsonNode schema = data.get(FIELD_MYSQL_TYPE);
        if (isNull(schema)) {
            LOG.debug(
                    "Cannot get original field types because '{}' field is missing.",
                    FIELD_MYSQL_TYPE);
            return null;
        }

        return JsonSerdeUtil.convertValue(
                schema, new TypeReference<LinkedHashMap<String, String>>() {});
    }

    @Override
    protected String primaryField() {
        return "pkNames";
    }

    @Override
    protected String dataField() {
        return FIELD_AFTER;
    }

    @Override
    protected void setRoot(CdcSourceRecord record) {
        try {
            BinLog.Binlog binlog = BinLog.Binlog.parseFrom((byte[]) record.getValue());
            if (binlog.getType().equals("DDL")) {
                return;
            }
            // 所有变更table
            List<BinLog.Table> tablesList = binlog.getDmlData().getTablesList();
            List<JsonNode> arrayData = new ArrayList<>();

            for (BinLog.Table table : tablesList) {
                String tableName = table.getTableName();
                if (!shouldSynchronizeCurrentTable(tableName)
                        || tableName.contentEquals("history")) {
                    continue;
                }
                List<BinLog.ColumnInfo> columnInfoList = table.getColumnInfoList();
                List<BinLog.TableMutation> mutationsList = table.getMutationsList();
                List<String> primaryKeys = new ArrayList<>();

                Map<String, String> fieldsInfo = new HashMap<>();
                for (BinLog.ColumnInfo columnInfo : columnInfoList) {
                    if (columnInfo.getIsPrimaryKey()) {
                        primaryKeys.add(columnInfo.getName());
                    }
                    fieldsInfo.put(columnInfo.getName(), columnInfo.getMysqlType().toUpperCase());
                }
                for (BinLog.TableMutation tableMutation : mutationsList) {
                    Map<String, Object> map = new HashMap<>();
                    Map<String, Object> dataMap = new HashMap<>();
                    Map<String, Object> beforeChangeMap = new HashMap<>();

                    map.put(FIELD_DATABASE, table.getSchemaName());
                    map.put("ts", System.currentTimeMillis());
                    map.put(FIELD_TABLE, table.getTableName());
                    List<BinLog.Column> columnsList = tableMutation.getRow().getColumnsList();
                    if (UPDATE_VALUE == tableMutation.getType().getNumber()) {
                        map.put(FIELD_TYPE, OP_UPDATE);

                        List<BinLog.Column> changeColumnsList =
                                tableMutation.getChangeRow().getColumnsList();
                        int countColumn = 0;
                        for (BinLog.ColumnInfo columnInfo : columnInfoList) {
                            String name = columnInfo.getName();
                            Object columnValue = getColumnValue(columnsList.get(countColumn));
                            dataMap.put(name, columnValue);
                            beforeChangeMap.put(
                                    name, getColumnValue(changeColumnsList.get(countColumn)));
                            countColumn++;
                        }

                    } else if (tableMutation.getType().getNumber() != DELETE_VALUE) {
                        map.put(FIELD_TYPE, OP_INSERT);
                        int countColumn = 0;
                        for (BinLog.ColumnInfo columnInfo : columnInfoList) {
                            String name = columnInfo.getName();
                            Object columnValue = getColumnValue(columnsList.get(countColumn));
                            dataMap.put(name, columnValue);
                            countColumn++;
                        }
                    }

                    map.put(FIELD_AFTER, dataMap);
                    map.put(FIELD_MYSQL_TYPE, fieldsInfo);
                    map.put(FIELD_BEFORE, beforeChangeMap);

                    map.put(FIELD_PRIMARY, primaryKeys);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(map);
                    arrayData.add(JsonSerdeUtil.fromJson(json, JsonNode.class));
                }
            }
            root = JsonSerdeUtil.fromJson(JsonSerdeUtil.toJson(arrayData), ArrayNode.class);
        } catch (Exception e) {
            LOG.error("parse failed：{}", e);
        }
    }

    @Override
    protected String format() {
        return "tidb-binlog";
    }

    private Object getColumnValue(BinLog.Column column) {
        Object columnValue = null;
        if (column.hasBytesValue()) {
            columnValue = column.getBytesValue();
        } else if (column.hasDoubleValue()) {
            columnValue = column.getDoubleValue();
        } else if (column.hasInt64Value()) {
            columnValue = column.getInt64Value();
        } else if (column.hasStringValue()) {
            columnValue = column.getStringValue();
        } else if (column.hasUint64Value()) {
            columnValue = column.getUint64Value();
        } else if (column.hasIsNull()) {
            columnValue = null;
        }
        return columnValue;
    }
}
