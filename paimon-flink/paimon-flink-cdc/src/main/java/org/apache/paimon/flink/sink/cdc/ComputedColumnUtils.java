package org.apache.paimon.flink.sink.cdc;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.paimon.catalog.Identifier;
import org.apache.paimon.flink.action.cdc.ComputedColumn;
import org.apache.paimon.schema.SchemaManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.paimon.flink.action.cdc.ComputedColumnUtils.buildComputedColumns;

public class ComputedColumnUtils {

    private final Map<String, List<ComputedColumn>> computedColumnMap = new HashMap<>();

    public static DataStream<CdcRecord> cdcRecordConvert(
            List<String> computedColumnArgs, DataStream<CdcRecord> input) {
        return input.forward().process(new ProcessFunction<CdcRecord, CdcRecord>() {
            @Override
            public void processElement(CdcRecord cdcRecord, ProcessFunction<CdcRecord, CdcRecord>.Context context, Collector<CdcRecord> collector) throws Exception {

//                Map<String, String> fields = cdcRecord.;
//                buildComputedColumns(computedColumnArgs, fields);

            }
        }).name("computed-column-converter");
    }
}
