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

package org.apache.paimon.flink.sink.cdc;

import org.apache.paimon.catalog.Catalog;
import org.apache.paimon.catalog.Identifier;
import org.apache.paimon.flink.action.cdc.ComputedColumn;
import org.apache.paimon.types.DataField;

import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A {@link ProcessFunction} to parse CDC change event to either a list of {@link DataField}s or
 * {@link CdcRecord} and send them to different side outputs according to table name. This process
 * function will capture newly added tables when syncing entire database and in cases where the
 * newly added tables are including by attesting table filters.
 *
 * <p>This {@link ProcessFunction} can handle records for different tables at the same time.
 *
 * @param <T> CDC change event type
 */
public class CdcDynamicTableParsingProcessFunction<T> extends ProcessFunction<T, Void> {

    private static final Logger LOG =
            LoggerFactory.getLogger(CdcDynamicTableParsingProcessFunction.class);

    public static final OutputTag<CdcMultiplexRecord> DYNAMIC_OUTPUT_TAG =
            new OutputTag<>("paimon-dynamic-table", TypeInformation.of(CdcMultiplexRecord.class));

    public static final OutputTag<Tuple2<Identifier, List<DataField>>>
            DYNAMIC_SCHEMA_CHANGE_OUTPUT_TAG =
                    new OutputTag<>(
                            "paimon-dynamic-table-schema-change",
                            TypeInformation.of(
                                    new TypeHint<Tuple2<Identifier, List<DataField>>>() {}));

    private final EventParser.Factory<T> parserFactory;
    private final String database;
    private final Catalog.Loader catalogLoader;

    private transient EventParser<T> parser;
    private transient Catalog catalog;

    public CdcDynamicTableParsingProcessFunction(
            String database, Catalog.Loader catalogLoader, EventParser.Factory<T> parserFactory) {
        // for now, only support single database
        this.database = database;
        this.catalogLoader = catalogLoader;
        this.parserFactory = parserFactory;
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        parser = parserFactory.create();
        catalog = catalogLoader.load();
    }

    @Override
    public void processElement(T raw, Context context, Collector<Void> collector) throws Exception {
        parser.setRawEvent(raw);

        // CDC Ingestion only supports single database at this time being.
        //    In the future, there will be a mapping between source databases
        //    and target paimon databases
        // TODO: support multiple databases
        // String databaseName = parser.parseDatabaseName();
        String tableName = parser.parseTableName();

        // check for newly added table
        parser.parseNewTable()
                .ifPresent(
                        schema -> {
                            Identifier identifier = new Identifier(database, tableName);
                            try {
                                catalog.createTable(identifier, schema, true);
                            } catch (Exception e) {
                                LOG.error(
                                        "Cannot create newly added Paimon table {}",
                                        identifier.getFullName(),
                                        e);
                            }
                        });
        RichCdcMultiplexRecordEventParser parserNew = (RichCdcMultiplexRecordEventParser) parser;
        if (parserNew.getSchemaBuilder().getComputedColumns() != null
                && !parserNew.getSchemaBuilder().getComputedColumns().isEmpty()) {
            NewTableSchemaBuilder schemaBuilder = parserNew.getSchemaBuilder();
            List<DataField> fieldsOld = parserNew.getRecord().fields();

            List<DataField> fieldsNew = new ArrayList<>();
            List<CdcRecord> cdcRecords = parser.parseRecords();
            List<ComputedColumn> computedColumns = schemaBuilder.getComputedColumns();

            for (int i = 0; i < cdcRecords.size(); i++) { // one element
                CdcRecord cdcRecord = cdcRecords.get(i);
                Map<String, String> fields = cdcRecord.fields();
                fieldsNew.addAll(fieldsOld);
                computedColumns.forEach(
                        computedColumn -> {
                            fieldsNew.add(
                                    new DataField(
                                            fields.size(),
                                            computedColumn.columnName(),
                                            computedColumn.columnType()));
                            fields.put(
                                    computedColumn.columnName(),
                                    computedColumn.eval(
                                            fields.get(computedColumn.fieldReference())));
                        });
                RichCdcMultiplexRecord richCdcMultiplexRecord =
                        new RichCdcMultiplexRecord(
                                database,
                                ((RichCdcMultiplexRecord) raw).tableName(),
                                fieldsNew,
                                schemaBuilder.getPrimaryKeys(),
                                cdcRecord);
                parserNew.setRawEvent(richCdcMultiplexRecord);
            }
        }

        List<DataField> schemaChange = parserNew.parseSchemaChange();
        if (!schemaChange.isEmpty()) {
            context.output(
                    DYNAMIC_SCHEMA_CHANGE_OUTPUT_TAG,
                    Tuple2.of(Identifier.create(database, tableName), schemaChange));
        }

        parserNew
                .parseRecords()
                .forEach(
                        record ->
                                context.output(
                                        DYNAMIC_OUTPUT_TAG,
                                        wrapRecord(database, tableName, record)));
    }

    private CdcMultiplexRecord wrapRecord(String databaseName, String tableName, CdcRecord record) {
        return CdcMultiplexRecord.fromCdcRecord(databaseName, tableName, record);
    }

    @Override
    public void close() throws Exception {
        if (catalog != null) {
            catalog.close();
            catalog = null;
        }
    }
}
