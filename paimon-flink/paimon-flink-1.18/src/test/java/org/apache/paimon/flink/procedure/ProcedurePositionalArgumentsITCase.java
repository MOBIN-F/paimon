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

package org.apache.paimon.flink.procedure;

import org.apache.paimon.flink.CatalogITCaseBase;
import org.apache.paimon.table.FileStoreTable;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

/** Ensure that the legacy multiply overloaded CALL with positional arguments can be invoked. */
public class ProcedurePositionalArgumentsITCase extends CatalogITCaseBase {

    @Test
    public void testCallCompact() {
        sql(
                "CREATE TABLE T ("
                        + " k INT,"
                        + " v INT,"
                        + " pt INT,"
                        + " PRIMARY KEY (k, pt) NOT ENFORCED"
                        + ") PARTITIONED BY (pt) WITH ("
                        + " 'write-only' = 'true',"
                        + " 'bucket' = '1'"
                        + ")");

        assertThatCode(() -> sql("CALL sys.compact('default.T')")).doesNotThrowAnyException();
        assertThatCode(() -> sql("CALL sys.compact('default.T', 'pt=1')"))
                .doesNotThrowAnyException();
        assertThatCode(() -> sql("CALL sys.compact('default.T', 'pt=1', '', '')"))
                .doesNotThrowAnyException();
        assertThatCode(() -> sql("CALL sys.compact('default.T', '', '', '', 'sink.parallelism=1')"))
                .doesNotThrowAnyException();
        assertThatCode(
                        () ->
                                sql(
                                        "CALL sys.compact('default.T', '', '', '', 'sink.parallelism=1','pt=1')"))
                .doesNotThrowAnyException();
    }

    @Test
    public void testExpirePartitionsProcedure() throws Exception {
        sql(
                "CREATE TABLE T ("
                        + " k STRING,"
                        + " dt STRING,"
                        + " PRIMARY KEY (k, dt) NOT ENFORCED"
                        + ") PARTITIONED BY (dt) WITH ("
                        + " 'bucket' = '1'"
                        + ")");
        FileStoreTable table = paimonTable("T");
        sql("INSERT INTO T VALUES ('1', '2024-06-01')");
        sql("INSERT INTO T VALUES ('2', '9024-06-01')");
        assertThat(read(table)).containsExactlyInAnyOrder("1:2024-06-01", "2:9024-06-01");
        sql("CALL sys.expire_partitions('default.T', '1 d', 'yyyy-MM-dd', 'values-time')");
        assertThat(read(table)).containsExactlyInAnyOrder("2:9024-06-01");
    }

    private List<String> read(FileStoreTable table) throws IOException {
        List<String> ret = new ArrayList<>();
        table.newRead()
                .createReader(table.newScan().plan().splits())
                .forEachRemaining(row -> ret.add(row.getString(0) + ":" + row.getString(1)));
        return ret;
    }
}
