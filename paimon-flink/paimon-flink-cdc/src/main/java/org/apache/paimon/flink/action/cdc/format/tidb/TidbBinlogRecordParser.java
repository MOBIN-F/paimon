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

import org.apache.paimon.flink.action.cdc.ComputedColumn;
import org.apache.paimon.flink.action.cdc.TypeMapping;
import org.apache.paimon.flink.action.cdc.format.RecordParser;
import org.apache.paimon.flink.sink.cdc.RichCdcMultiplexRecord;
import org.apache.paimon.types.RowKind;
import org.apache.paimon.utils.JsonSerdeUtil;

import org.apache.paimon.shade.jackson2.com.fasterxml.jackson.databind.JsonNode;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.apache.paimon.utils.JsonSerdeUtil.isNull;

public class TidbBinlogRecordParser extends RecordParser<byte[]> {

    private static final Logger LOG = LoggerFactory.getLogger(TidbBinlogRecordParser.class);

    private static final String FIELD_IS_DDL = "isDdl";
    private static final String FIELD_BEFORE = "before";
    private static final String FIELD_AFTER = "after";
    private static final String FIELD_PRIMARY = "pkNames";
    private static final String FIELD_TYPE = "type";
    private static final String OP_UPDATE = "Update";
    private static final String OP_INSERT = "Insert";
    private static final String OP_DELETE = "Delete";

    public TidbBinlogRecordParser(
            boolean caseSensitive, TypeMapping typeMapping, List<ComputedColumn> computedColumns) {
        super(caseSensitive, typeMapping, computedColumns);
    }

    @Override
    protected boolean isDDL() {
        JsonNode node = root.get(FIELD_IS_DDL);
        return !isNull(node) && node.asBoolean();
    }

    @Override
    protected List<RichCdcMultiplexRecord> extractRecords() {
        String operation = getAndCheck(FIELD_TYPE).asText();
        JsonNode data = getData();
        List<RichCdcMultiplexRecord> records = new ArrayList<>();
        switch (operation) {
            case OP_INSERT:
                processRecord(data, RowKind.INSERT, records);
                break;
            case OP_UPDATE:
                processRecord(mergeOldRecord(data, getBefore(operation)), RowKind.DELETE, records);
                processRecord(data, RowKind.INSERT, records);
                break;
            case OP_DELETE:
                processRecord(data, RowKind.DELETE, records);
                break;
            default:
                throw new UnsupportedOperationException("Unknown record operation: " + operation);
        }
        return records;
    }

    private JsonNode getData() {
        return getAndCheck(dataField());
    }

    private JsonNode getBefore(String op) {
        return getAndCheck(FIELD_BEFORE, FIELD_TYPE, op);
    }

    @Override
    protected void setRoot(byte[] record) {
        try {
            BinLog.Binlog binlog = BinLog.Binlog.parseFrom(record);
            // 所有变更table
            List<BinLog.Table> tablesList = binlog.getDmlData().getTablesList();
            int tableSeqNum = 0;
            for (BinLog.Table table : tablesList) {
                List<BinLog.ColumnInfo> columnInfoList = table.getColumnInfoList();
                List<BinLog.TableMutation> mutationsList = table.getMutationsList();
                int mutationSeqNum = 0;
                List<String> primaryKeys = new ArrayList<>();
                for (BinLog.ColumnInfo columnInfo : columnInfoList) {
                    if (columnInfo.getIsPrimaryKey()) {
                        primaryKeys.add(columnInfo.getName());
                    }
                }
                for (BinLog.TableMutation tableMutation : mutationsList) {
                    Map<String, Object> map = new HashMap<>();
                    Map<String, Object> dateMap = new HashMap<>();
                    Map<String, Object> beforeChangeMap = new HashMap<>();
                    map.put("isDdl", binlog.getType());
                    map.put(FIELD_DATABASE, table.getSchemaName());
                    map.put("sysExecuteTime", System.currentTimeMillis());
                    map.put(FIELD_TABLE, table.getTableName());
                    map.put("commitTs", binlog.toBuilder().getCommitTs());
                    map.put("tableSeqNum", tableSeqNum);
                    map.put("mutationSeqNum", mutationSeqNum++);
                    List<BinLog.Column> columnsList = tableMutation.getRow().getColumnsList();

                    if (OP_UPDATE.equals(tableMutation.getType())) {
                        map.put(FIELD_TYPE, OP_UPDATE);

                        List<BinLog.Column> changeColumnsList =
                                tableMutation.getChangeRow().getColumnsList();
                        int countColumn = 0;
                        for (BinLog.ColumnInfo columnInfo : columnInfoList) {
                            String name = columnInfo.getName();
                            Object columnValue = getColumnValue(columnsList.get(countColumn));
                            dateMap.put(name, columnValue);
                            beforeChangeMap.put(
                                    name, getColumnValue(changeColumnsList.get(countColumn)));
                            countColumn++;
                        }

                    } else {
                        map.put(FIELD_TYPE, tableMutation.getType());
                        int countColumn = 0;
                        for (BinLog.ColumnInfo columnInfo : columnInfoList) {
                            String name = columnInfo.getName();
                            Object columnValue = getColumnValue(columnsList.get(countColumn));
                            dateMap.put(name, columnValue);
                            countColumn++;
                        }
                    }
                    map.put(FIELD_AFTER, dateMap);
                    map.put(FIELD_BEFORE, beforeChangeMap);
                    map.put(FIELD_PRIMARY, primaryKeys);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(map);
                    root = JsonSerdeUtil.fromJson(json, JsonNode.class);
                    System.out.println(root);
                }
                tableSeqNum++;
            }
        } catch (Throwable t) {

            //            throw new IOException(format("Failed to deserialize JSON '%s'.", new
            // String(record)), t);
        }
    }

    @Override
    protected String primaryField() {
        return FIELD_PRIMARY;
    }

    @Override
    protected String dataField() {
        return FIELD_AFTER;
    }

    @Override
    protected String format() {
        return "fctidb_binlog";
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
