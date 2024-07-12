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

package org.apache.paimon.flink.action.cdc;

import org.apache.paimon.shade.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.paimon.shade.jackson2.com.fasterxml.jackson.databind.DeserializationFeature;
import org.apache.paimon.shade.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.paimon.shade.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.Nullable;

import java.io.Serializable;
import java.util.Objects;

/** A data change record from the CDC source. */
public class CdcSourceRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Nullable private final String topic;

    @Nullable private final Object key;

    // TODO Use generics to support more scenarios.
    private final byte[] value;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CdcSourceRecord(@Nullable String topic, @Nullable Object key, byte[] value) {
        this.topic = topic;
        this.key = key;
        this.value = value;
        this.objectMapper
                .configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public CdcSourceRecord(byte[] value) {
        this(null, null, value);
    }

    @Nullable
    public String getTopic() {
        return topic;
    }

    @Nullable
    public Object getKey() {
        return key;
    }

    public JsonNode getJsonNodeValue() {
        try {
            return objectMapper.readValue(new String(value), JsonNode.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Invalid Json:\n" + new String(value));
        }
    }

    public byte[] getByteValue() {
        return value;
    }

    public String getStringValue() {
        return new String(value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CdcSourceRecord)) {
            return false;
        }

        CdcSourceRecord that = (CdcSourceRecord) o;
        return Objects.equals(topic, that.topic)
                && Objects.equals(key, that.key)
                && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, key, value);
    }

    @Override
    public String toString() {
        return topic + ": " + key + " " + value;
    }
}
