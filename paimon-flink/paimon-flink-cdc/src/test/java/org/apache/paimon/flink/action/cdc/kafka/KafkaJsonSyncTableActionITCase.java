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

package org.apache.paimon.flink.action.cdc.kafka;

import org.apache.paimon.types.DataType;
import org.apache.paimon.types.DataTypes;
import org.apache.paimon.types.RowType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.*;

import static org.apache.flink.streaming.connectors.kafka.table.KafkaConnectorOptions.*;
import static org.apache.flink.streaming.connectors.kafka.table.KafkaConnectorOptions.ScanStartupMode.*;

/** IT cases for {@link KafkaSyncTableAction}. */
public class KafkaJsonSyncTableActionITCase extends KafkaSyncTableActionITCase {

    @Test
    @Timeout(60)
    public void testSynchronizeIncompleteJson() throws Exception {
        String topic = "incomplete";
        createTestTopic(topic, 1, 1);
        writeRecordsToKafka(topic, "kafka/json/table/json-data-1.txt");

        Map<String, String> kafkaConfig = getBasicKafkaConfig();
        kafkaConfig.put(VALUE_FORMAT.key(), "json");
        kafkaConfig.put(TOPIC.key(), topic);
        KafkaSyncTableAction action =
                syncTableActionBuilder(kafkaConfig).withTableConfig(getBasicTableConfig()).build();

        runActionWithDefaultEnv(action);

        RowType rowType =
                RowType.of(
                        new DataType[] {DataTypes.STRING(), DataTypes.STRING(), DataTypes.STRING()},
                        new String[] {"a", "b", "c"});
        waitForResult(
                Arrays.asList("+I[a1, b1, NULL]", "+I[a2, b2, c2]"),
                getFileStoreTable(tableName),
                rowType,
                Collections.emptyList());
    }
}
