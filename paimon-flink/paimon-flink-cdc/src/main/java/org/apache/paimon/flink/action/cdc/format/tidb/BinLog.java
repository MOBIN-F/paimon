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

public final class BinLog {
    private BinLog() {}

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
    }
    /** Protobuf enum {@code slave.binlog.MutationType} */
    public enum MutationType implements com.google.protobuf.ProtocolMessageEnum {
        /** <code>Insert = 0;</code> */
        Insert(0),
        /** <code>Update = 1;</code> */
        Update(1),
        /** <code>Delete = 2;</code> */
        Delete(2),
        ;

        /** <code>Insert = 0;</code> */
        public static final int Insert_VALUE = 0;
        /** <code>Update = 1;</code> */
        public static final int Update_VALUE = 1;
        /** <code>Delete = 2;</code> */
        public static final int Delete_VALUE = 2;

        public final int getNumber() {
            return value;
        }

        /** @deprecated Use {@link #forNumber(int)} instead. */
        @Deprecated
        public static MutationType valueOf(int value) {
            return forNumber(value);
        }

        public static MutationType forNumber(int value) {
            switch (value) {
                case 0:
                    return Insert;
                case 1:
                    return Update;
                case 2:
                    return Delete;
                default:
                    return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<MutationType> internalGetValueMap() {
            return internalValueMap;
        }

        private static final com.google.protobuf.Internal.EnumLiteMap<MutationType>
                internalValueMap =
                        new com.google.protobuf.Internal.EnumLiteMap<MutationType>() {
                            public MutationType findValueByNumber(int number) {
                                return MutationType.forNumber(number);
                            }
                        };

        public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
            return BinLog.getDescriptor().getEnumTypes().get(0);
        }

        private static final MutationType[] VALUES = values();

        public static MutationType valueOf(
                com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            return VALUES[desc.getIndex()];
        }

        private final int value;

        private MutationType(int value) {
            this.value = value;
        }

        // @@protoc_insertion_point(enum_scope:slave.binlog.MutationType)
    }

    /** Protobuf enum {@code slave.binlog.BinlogType} */
    public enum BinlogType implements com.google.protobuf.ProtocolMessageEnum {
        /**
         *
         *
         * <pre>
         *  has dml_data
         * </pre>
         *
         * <code>DML = 0;</code>
         */
        DML(0),
        /**
         *
         *
         * <pre>
         *  has ddl_query
         * </pre>
         *
         * <code>DDL = 1;</code>
         */
        DDL(1),
        ;

        /**
         *
         *
         * <pre>
         *  has dml_data
         * </pre>
         *
         * <code>DML = 0;</code>
         */
        public static final int DML_VALUE = 0;
        /**
         *
         *
         * <pre>
         *  has ddl_query
         * </pre>
         *
         * <code>DDL = 1;</code>
         */
        public static final int DDL_VALUE = 1;

        public final int getNumber() {
            return value;
        }

        /** @deprecated Use {@link #forNumber(int)} instead. */
        @Deprecated
        public static BinlogType valueOf(int value) {
            return forNumber(value);
        }

        public static BinlogType forNumber(int value) {
            switch (value) {
                case 0:
                    return DML;
                case 1:
                    return DDL;
                default:
                    return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<BinlogType> internalGetValueMap() {
            return internalValueMap;
        }

        private static final com.google.protobuf.Internal.EnumLiteMap<BinlogType> internalValueMap =
                new com.google.protobuf.Internal.EnumLiteMap<BinlogType>() {
                    public BinlogType findValueByNumber(int number) {
                        return BinlogType.forNumber(number);
                    }
                };

        public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
            return BinLog.getDescriptor().getEnumTypes().get(1);
        }

        private static final BinlogType[] VALUES = values();

        public static BinlogType valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            return VALUES[desc.getIndex()];
        }

        private final int value;

        private BinlogType(int value) {
            this.value = value;
        }

        // @@protoc_insertion_point(enum_scope:slave.binlog.BinlogType)
    }

    public interface ColumnOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:slave.binlog.Column)
            com.google.protobuf.MessageOrBuilder {

        /** <code>optional bool is_null = 1 [default = false];</code> */
        boolean hasIsNull();
        /** <code>optional bool is_null = 1 [default = false];</code> */
        boolean getIsNull();

        /** <code>optional int64 int64_value = 2;</code> */
        boolean hasInt64Value();
        /** <code>optional int64 int64_value = 2;</code> */
        long getInt64Value();

        /** <code>optional uint64 uint64_value = 3;</code> */
        boolean hasUint64Value();
        /** <code>optional uint64 uint64_value = 3;</code> */
        long getUint64Value();

        /** <code>optional double double_value = 4;</code> */
        boolean hasDoubleValue();
        /** <code>optional double double_value = 4;</code> */
        double getDoubleValue();

        /** <code>optional bytes bytes_value = 5;</code> */
        boolean hasBytesValue();
        /** <code>optional bytes bytes_value = 5;</code> */
        com.google.protobuf.ByteString getBytesValue();

        /** <code>optional string string_value = 6;</code> */
        boolean hasStringValue();
        /** <code>optional string string_value = 6;</code> */
        String getStringValue();
        /** <code>optional string string_value = 6;</code> */
        com.google.protobuf.ByteString getStringValueBytes();
    }
    /**
     *
     *
     * <pre>
     * for text and char type, string_value is set
     * for blob and binary type, bytes_value is set
     * for enum, set, uint64_value is set
     * for json, bytes_value is set
     * </pre>
     *
     * Protobuf type {@code slave.binlog.Column}
     */
    public static final class Column extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:slave.binlog.Column)
            ColumnOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use Column.newBuilder() to construct.
        private Column(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private Column() {
            bytesValue_ = com.google.protobuf.ByteString.EMPTY;
            stringValue_ = "";
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Column(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            {
                                bitField0_ |= 0x00000001;
                                isNull_ = input.readBool();
                                break;
                            }
                        case 16:
                            {
                                bitField0_ |= 0x00000002;
                                int64Value_ = input.readInt64();
                                break;
                            }
                        case 24:
                            {
                                bitField0_ |= 0x00000004;
                                uint64Value_ = input.readUInt64();
                                break;
                            }
                        case 33:
                            {
                                bitField0_ |= 0x00000008;
                                doubleValue_ = input.readDouble();
                                break;
                            }
                        case 42:
                            {
                                bitField0_ |= 0x00000010;
                                bytesValue_ = input.readBytes();
                                break;
                            }
                        case 50:
                            {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000020;
                                stringValue_ = bs;
                                break;
                            }
                        default:
                            {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return BinLog.internal_static_slave_binlog_Column_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return BinLog.internal_static_slave_binlog_Column_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(Column.class, Builder.class);
        }

        private int bitField0_;
        public static final int IS_NULL_FIELD_NUMBER = 1;
        private boolean isNull_;
        /** <code>optional bool is_null = 1 [default = false];</code> */
        public boolean hasIsNull() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /** <code>optional bool is_null = 1 [default = false];</code> */
        public boolean getIsNull() {
            return isNull_;
        }

        public static final int INT64_VALUE_FIELD_NUMBER = 2;
        private long int64Value_;
        /** <code>optional int64 int64_value = 2;</code> */
        public boolean hasInt64Value() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /** <code>optional int64 int64_value = 2;</code> */
        public long getInt64Value() {
            return int64Value_;
        }

        public static final int UINT64_VALUE_FIELD_NUMBER = 3;
        private long uint64Value_;
        /** <code>optional uint64 uint64_value = 3;</code> */
        public boolean hasUint64Value() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }
        /** <code>optional uint64 uint64_value = 3;</code> */
        public long getUint64Value() {
            return uint64Value_;
        }

        public static final int DOUBLE_VALUE_FIELD_NUMBER = 4;
        private double doubleValue_;
        /** <code>optional double double_value = 4;</code> */
        public boolean hasDoubleValue() {
            return ((bitField0_ & 0x00000008) == 0x00000008);
        }
        /** <code>optional double double_value = 4;</code> */
        public double getDoubleValue() {
            return doubleValue_;
        }

        public static final int BYTES_VALUE_FIELD_NUMBER = 5;
        private com.google.protobuf.ByteString bytesValue_;
        /** <code>optional bytes bytes_value = 5;</code> */
        public boolean hasBytesValue() {
            return ((bitField0_ & 0x00000010) == 0x00000010);
        }
        /** <code>optional bytes bytes_value = 5;</code> */
        public com.google.protobuf.ByteString getBytesValue() {
            return bytesValue_;
        }

        public static final int STRING_VALUE_FIELD_NUMBER = 6;
        private volatile Object stringValue_;
        /** <code>optional string string_value = 6;</code> */
        public boolean hasStringValue() {
            return ((bitField0_ & 0x00000020) == 0x00000020);
        }
        /** <code>optional string string_value = 6;</code> */
        public String getStringValue() {
            Object ref = stringValue_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    stringValue_ = s;
                }
                return s;
            }
        }
        /** <code>optional string string_value = 6;</code> */
        public com.google.protobuf.ByteString getStringValueBytes() {
            Object ref = stringValue_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                stringValue_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeBool(1, isNull_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeInt64(2, int64Value_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeUInt64(3, uint64Value_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                output.writeDouble(4, doubleValue_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                output.writeBytes(5, bytesValue_);
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 6, stringValue_);
            }
            unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream.computeBoolSize(1, isNull_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, int64Value_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream.computeUInt64Size(3, uint64Value_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                size += com.google.protobuf.CodedOutputStream.computeDoubleSize(4, doubleValue_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                size += com.google.protobuf.CodedOutputStream.computeBytesSize(5, bytesValue_);
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, stringValue_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Column)) {
                return super.equals(obj);
            }
            Column other = (Column) obj;

            boolean result = true;
            result = result && (hasIsNull() == other.hasIsNull());
            if (hasIsNull()) {
                result = result && (getIsNull() == other.getIsNull());
            }
            result = result && (hasInt64Value() == other.hasInt64Value());
            if (hasInt64Value()) {
                result = result && (getInt64Value() == other.getInt64Value());
            }
            result = result && (hasUint64Value() == other.hasUint64Value());
            if (hasUint64Value()) {
                result = result && (getUint64Value() == other.getUint64Value());
            }
            result = result && (hasDoubleValue() == other.hasDoubleValue());
            if (hasDoubleValue()) {
                result =
                        result
                                && (Double.doubleToLongBits(getDoubleValue())
                                        == Double.doubleToLongBits(other.getDoubleValue()));
            }
            result = result && (hasBytesValue() == other.hasBytesValue());
            if (hasBytesValue()) {
                result = result && getBytesValue().equals(other.getBytesValue());
            }
            result = result && (hasStringValue() == other.hasStringValue());
            if (hasStringValue()) {
                result = result && getStringValue().equals(other.getStringValue());
            }
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasIsNull()) {
                hash = (37 * hash) + IS_NULL_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsNull());
            }
            if (hasInt64Value()) {
                hash = (37 * hash) + INT64_VALUE_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getInt64Value());
            }
            if (hasUint64Value()) {
                hash = (37 * hash) + UINT64_VALUE_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getUint64Value());
            }
            if (hasDoubleValue()) {
                hash = (37 * hash) + DOUBLE_VALUE_FIELD_NUMBER;
                hash =
                        (53 * hash)
                                + com.google.protobuf.Internal.hashLong(
                                        Double.doubleToLongBits(getDoubleValue()));
            }
            if (hasBytesValue()) {
                hash = (37 * hash) + BYTES_VALUE_FIELD_NUMBER;
                hash = (53 * hash) + getBytesValue().hashCode();
            }
            if (hasStringValue()) {
                hash = (37 * hash) + STRING_VALUE_FIELD_NUMBER;
                hash = (53 * hash) + getStringValue().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static Column parseFrom(java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Column parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Column parseFrom(com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Column parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Column parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Column parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Column parseFrom(java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Column parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static Column parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input);
        }

        public static Column parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static Column parseFrom(com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Column parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Column prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         *
         *
         * <pre>
         * for text and char type, string_value is set
         * for blob and binary type, bytes_value is set
         * for enum, set, uint64_value is set
         * for json, bytes_value is set
         * </pre>
         *
         * Protobuf type {@code slave.binlog.Column}
         */
        public static final class Builder
                extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:slave.binlog.Column)
                ColumnOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return BinLog.internal_static_slave_binlog_Column_descriptor;
            }

            @Override
            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return BinLog.internal_static_slave_binlog_Column_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(Column.class, Builder.class);
            }

            // Construct using com.fcbox.move.bean.BinLog.Column.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
            }

            @Override
            public Builder clear() {
                super.clear();
                isNull_ = false;
                bitField0_ = (bitField0_ & ~0x00000001);
                int64Value_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000002);
                uint64Value_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000004);
                doubleValue_ = 0D;
                bitField0_ = (bitField0_ & ~0x00000008);
                bytesValue_ = com.google.protobuf.ByteString.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000010);
                stringValue_ = "";
                bitField0_ = (bitField0_ & ~0x00000020);
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return BinLog.internal_static_slave_binlog_Column_descriptor;
            }

            @Override
            public Column getDefaultInstanceForType() {
                return Column.getDefaultInstance();
            }

            @Override
            public Column build() {
                Column result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public Column buildPartial() {
                Column result = new Column(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    result.isNull_ = isNull_;
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    result.int64Value_ = int64Value_;
                    to_bitField0_ |= 0x00000002;
                }
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    result.uint64Value_ = uint64Value_;
                    to_bitField0_ |= 0x00000004;
                }
                if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
                    result.doubleValue_ = doubleValue_;
                    to_bitField0_ |= 0x00000008;
                }
                if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
                    to_bitField0_ |= 0x00000010;
                }
                result.bytesValue_ = bytesValue_;
                if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
                    to_bitField0_ |= 0x00000020;
                }
                result.stringValue_ = stringValue_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override
            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override
            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index,
                    Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Column) {
                    return mergeFrom((Column) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(Column other) {
                if (other == Column.getDefaultInstance()) return this;
                if (other.hasIsNull()) {
                    setIsNull(other.getIsNull());
                }
                if (other.hasInt64Value()) {
                    setInt64Value(other.getInt64Value());
                }
                if (other.hasUint64Value()) {
                    setUint64Value(other.getUint64Value());
                }
                if (other.hasDoubleValue()) {
                    setDoubleValue(other.getDoubleValue());
                }
                if (other.hasBytesValue()) {
                    setBytesValue(other.getBytesValue());
                }
                if (other.hasStringValue()) {
                    bitField0_ |= 0x00000020;
                    stringValue_ = other.stringValue_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                Column parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (Column) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private boolean isNull_;
            /** <code>optional bool is_null = 1 [default = false];</code> */
            public boolean hasIsNull() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /** <code>optional bool is_null = 1 [default = false];</code> */
            public boolean getIsNull() {
                return isNull_;
            }
            /** <code>optional bool is_null = 1 [default = false];</code> */
            public Builder setIsNull(boolean value) {
                bitField0_ |= 0x00000001;
                isNull_ = value;
                onChanged();
                return this;
            }
            /** <code>optional bool is_null = 1 [default = false];</code> */
            public Builder clearIsNull() {
                bitField0_ = (bitField0_ & ~0x00000001);
                isNull_ = false;
                onChanged();
                return this;
            }

            private long int64Value_;
            /** <code>optional int64 int64_value = 2;</code> */
            public boolean hasInt64Value() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /** <code>optional int64 int64_value = 2;</code> */
            public long getInt64Value() {
                return int64Value_;
            }
            /** <code>optional int64 int64_value = 2;</code> */
            public Builder setInt64Value(long value) {
                bitField0_ |= 0x00000002;
                int64Value_ = value;
                onChanged();
                return this;
            }
            /** <code>optional int64 int64_value = 2;</code> */
            public Builder clearInt64Value() {
                bitField0_ = (bitField0_ & ~0x00000002);
                int64Value_ = 0L;
                onChanged();
                return this;
            }

            private long uint64Value_;
            /** <code>optional uint64 uint64_value = 3;</code> */
            public boolean hasUint64Value() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }
            /** <code>optional uint64 uint64_value = 3;</code> */
            public long getUint64Value() {
                return uint64Value_;
            }
            /** <code>optional uint64 uint64_value = 3;</code> */
            public Builder setUint64Value(long value) {
                bitField0_ |= 0x00000004;
                uint64Value_ = value;
                onChanged();
                return this;
            }
            /** <code>optional uint64 uint64_value = 3;</code> */
            public Builder clearUint64Value() {
                bitField0_ = (bitField0_ & ~0x00000004);
                uint64Value_ = 0L;
                onChanged();
                return this;
            }

            private double doubleValue_;
            /** <code>optional double double_value = 4;</code> */
            public boolean hasDoubleValue() {
                return ((bitField0_ & 0x00000008) == 0x00000008);
            }
            /** <code>optional double double_value = 4;</code> */
            public double getDoubleValue() {
                return doubleValue_;
            }
            /** <code>optional double double_value = 4;</code> */
            public Builder setDoubleValue(double value) {
                bitField0_ |= 0x00000008;
                doubleValue_ = value;
                onChanged();
                return this;
            }
            /** <code>optional double double_value = 4;</code> */
            public Builder clearDoubleValue() {
                bitField0_ = (bitField0_ & ~0x00000008);
                doubleValue_ = 0D;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString bytesValue_ =
                    com.google.protobuf.ByteString.EMPTY;
            /** <code>optional bytes bytes_value = 5;</code> */
            public boolean hasBytesValue() {
                return ((bitField0_ & 0x00000010) == 0x00000010);
            }
            /** <code>optional bytes bytes_value = 5;</code> */
            public com.google.protobuf.ByteString getBytesValue() {
                return bytesValue_;
            }
            /** <code>optional bytes bytes_value = 5;</code> */
            public Builder setBytesValue(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                bytesValue_ = value;
                onChanged();
                return this;
            }
            /** <code>optional bytes bytes_value = 5;</code> */
            public Builder clearBytesValue() {
                bitField0_ = (bitField0_ & ~0x00000010);
                bytesValue_ = getDefaultInstance().getBytesValue();
                onChanged();
                return this;
            }

            private Object stringValue_ = "";
            /** <code>optional string string_value = 6;</code> */
            public boolean hasStringValue() {
                return ((bitField0_ & 0x00000020) == 0x00000020);
            }
            /** <code>optional string string_value = 6;</code> */
            public String getStringValue() {
                Object ref = stringValue_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        stringValue_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /** <code>optional string string_value = 6;</code> */
            public com.google.protobuf.ByteString getStringValueBytes() {
                Object ref = stringValue_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                    stringValue_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /** <code>optional string string_value = 6;</code> */
            public Builder setStringValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000020;
                stringValue_ = value;
                onChanged();
                return this;
            }
            /** <code>optional string string_value = 6;</code> */
            public Builder clearStringValue() {
                bitField0_ = (bitField0_ & ~0x00000020);
                stringValue_ = getDefaultInstance().getStringValue();
                onChanged();
                return this;
            }
            /** <code>optional string string_value = 6;</code> */
            public Builder setStringValueBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000020;
                stringValue_ = value;
                onChanged();
                return this;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:slave.binlog.Column)
        }

        // @@protoc_insertion_point(class_scope:slave.binlog.Column)
        private static final Column DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new Column();
        }

        public static Column getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<Column> PARSER =
                new com.google.protobuf.AbstractParser<Column>() {
                    @Override
                    public Column parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new Column(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<Column> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<Column> getParserForType() {
            return PARSER;
        }

        @Override
        public Column getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface ColumnInfoOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:slave.binlog.ColumnInfo)
            com.google.protobuf.MessageOrBuilder {

        /** <code>optional string name = 1;</code> */
        boolean hasName();
        /** <code>optional string name = 1;</code> */
        String getName();
        /** <code>optional string name = 1;</code> */
        com.google.protobuf.ByteString getNameBytes();

        /**
         *
         *
         * <pre>
         * lower case column field type in mysql
         * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
         * for numeric type: int bigint smallint tinyint float double decimal bit
         * for string type: text longtext mediumtext char tinytext varchar
         * blob longblog mediumblog binary tinyblob varbinary
         * enum set
         * for json type: json
         * </pre>
         *
         * <code>optional string mysql_type = 2;</code>
         */
        boolean hasMysqlType();
        /**
         *
         *
         * <pre>
         * lower case column field type in mysql
         * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
         * for numeric type: int bigint smallint tinyint float double decimal bit
         * for string type: text longtext mediumtext char tinytext varchar
         * blob longblog mediumblog binary tinyblob varbinary
         * enum set
         * for json type: json
         * </pre>
         *
         * <code>optional string mysql_type = 2;</code>
         */
        String getMysqlType();
        /**
         *
         *
         * <pre>
         * lower case column field type in mysql
         * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
         * for numeric type: int bigint smallint tinyint float double decimal bit
         * for string type: text longtext mediumtext char tinytext varchar
         * blob longblog mediumblog binary tinyblob varbinary
         * enum set
         * for json type: json
         * </pre>
         *
         * <code>optional string mysql_type = 2;</code>
         */
        com.google.protobuf.ByteString getMysqlTypeBytes();

        /** <code>optional bool is_primary_key = 3;</code> */
        boolean hasIsPrimaryKey();
        /** <code>optional bool is_primary_key = 3;</code> */
        boolean getIsPrimaryKey();
    }
    /** Protobuf type {@code slave.binlog.ColumnInfo} */
    public static final class ColumnInfo extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:slave.binlog.ColumnInfo)
            ColumnInfoOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ColumnInfo.newBuilder() to construct.
        private ColumnInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private ColumnInfo() {
            name_ = "";
            mysqlType_ = "";
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ColumnInfo(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000001;
                                name_ = bs;
                                break;
                            }
                        case 18:
                            {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000002;
                                mysqlType_ = bs;
                                break;
                            }
                        case 24:
                            {
                                bitField0_ |= 0x00000004;
                                isPrimaryKey_ = input.readBool();
                                break;
                            }
                        default:
                            {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return BinLog.internal_static_slave_binlog_ColumnInfo_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return BinLog.internal_static_slave_binlog_ColumnInfo_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(ColumnInfo.class, Builder.class);
        }

        private int bitField0_;
        public static final int NAME_FIELD_NUMBER = 1;
        private volatile Object name_;
        /** <code>optional string name = 1;</code> */
        public boolean hasName() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /** <code>optional string name = 1;</code> */
        public String getName() {
            Object ref = name_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    name_ = s;
                }
                return s;
            }
        }
        /** <code>optional string name = 1;</code> */
        public com.google.protobuf.ByteString getNameBytes() {
            Object ref = name_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                name_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int MYSQL_TYPE_FIELD_NUMBER = 2;
        private volatile Object mysqlType_;
        /**
         *
         *
         * <pre>
         * lower case column field type in mysql
         * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
         * for numeric type: int bigint smallint tinyint float double decimal bit
         * for string type: text longtext mediumtext char tinytext varchar
         * blob longblog mediumblog binary tinyblob varbinary
         * enum set
         * for json type: json
         * </pre>
         *
         * <code>optional string mysql_type = 2;</code>
         */
        public boolean hasMysqlType() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         *
         *
         * <pre>
         * lower case column field type in mysql
         * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
         * for numeric type: int bigint smallint tinyint float double decimal bit
         * for string type: text longtext mediumtext char tinytext varchar
         * blob longblog mediumblog binary tinyblob varbinary
         * enum set
         * for json type: json
         * </pre>
         *
         * <code>optional string mysql_type = 2;</code>
         */
        public String getMysqlType() {
            Object ref = mysqlType_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    mysqlType_ = s;
                }
                return s;
            }
        }
        /**
         *
         *
         * <pre>
         * lower case column field type in mysql
         * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
         * for numeric type: int bigint smallint tinyint float double decimal bit
         * for string type: text longtext mediumtext char tinytext varchar
         * blob longblog mediumblog binary tinyblob varbinary
         * enum set
         * for json type: json
         * </pre>
         *
         * <code>optional string mysql_type = 2;</code>
         */
        public com.google.protobuf.ByteString getMysqlTypeBytes() {
            Object ref = mysqlType_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                mysqlType_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int IS_PRIMARY_KEY_FIELD_NUMBER = 3;
        private boolean isPrimaryKey_;
        /** <code>optional bool is_primary_key = 3;</code> */
        public boolean hasIsPrimaryKey() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }
        /** <code>optional bool is_primary_key = 3;</code> */
        public boolean getIsPrimaryKey() {
            return isPrimaryKey_;
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, mysqlType_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeBool(3, isPrimaryKey_);
            }
            unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, mysqlType_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream.computeBoolSize(3, isPrimaryKey_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ColumnInfo)) {
                return super.equals(obj);
            }
            ColumnInfo other = (ColumnInfo) obj;

            boolean result = true;
            result = result && (hasName() == other.hasName());
            if (hasName()) {
                result = result && getName().equals(other.getName());
            }
            result = result && (hasMysqlType() == other.hasMysqlType());
            if (hasMysqlType()) {
                result = result && getMysqlType().equals(other.getMysqlType());
            }
            result = result && (hasIsPrimaryKey() == other.hasIsPrimaryKey());
            if (hasIsPrimaryKey()) {
                result = result && (getIsPrimaryKey() == other.getIsPrimaryKey());
            }
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasName()) {
                hash = (37 * hash) + NAME_FIELD_NUMBER;
                hash = (53 * hash) + getName().hashCode();
            }
            if (hasMysqlType()) {
                hash = (37 * hash) + MYSQL_TYPE_FIELD_NUMBER;
                hash = (53 * hash) + getMysqlType().hashCode();
            }
            if (hasIsPrimaryKey()) {
                hash = (37 * hash) + IS_PRIMARY_KEY_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getIsPrimaryKey());
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static ColumnInfo parseFrom(java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ColumnInfo parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ColumnInfo parseFrom(com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ColumnInfo parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ColumnInfo parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ColumnInfo parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ColumnInfo parseFrom(java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ColumnInfo parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static ColumnInfo parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input);
        }

        public static ColumnInfo parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static ColumnInfo parseFrom(com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ColumnInfo parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ColumnInfo prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /** Protobuf type {@code slave.binlog.ColumnInfo} */
        public static final class Builder
                extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:slave.binlog.ColumnInfo)
                ColumnInfoOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return BinLog.internal_static_slave_binlog_ColumnInfo_descriptor;
            }

            @Override
            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return BinLog.internal_static_slave_binlog_ColumnInfo_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(ColumnInfo.class, Builder.class);
            }

            // Construct using com.fcbox.move.bean.BinLog.ColumnInfo.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
            }

            @Override
            public Builder clear() {
                super.clear();
                name_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                mysqlType_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                isPrimaryKey_ = false;
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return BinLog.internal_static_slave_binlog_ColumnInfo_descriptor;
            }

            @Override
            public ColumnInfo getDefaultInstanceForType() {
                return ColumnInfo.getDefaultInstance();
            }

            @Override
            public ColumnInfo build() {
                ColumnInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public ColumnInfo buildPartial() {
                ColumnInfo result = new ColumnInfo(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.name_ = name_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.mysqlType_ = mysqlType_;
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    result.isPrimaryKey_ = isPrimaryKey_;
                    to_bitField0_ |= 0x00000004;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override
            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override
            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index,
                    Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof ColumnInfo) {
                    return mergeFrom((ColumnInfo) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(ColumnInfo other) {
                if (other == ColumnInfo.getDefaultInstance()) return this;
                if (other.hasName()) {
                    bitField0_ |= 0x00000001;
                    name_ = other.name_;
                    onChanged();
                }
                if (other.hasMysqlType()) {
                    bitField0_ |= 0x00000002;
                    mysqlType_ = other.mysqlType_;
                    onChanged();
                }
                if (other.hasIsPrimaryKey()) {
                    setIsPrimaryKey(other.getIsPrimaryKey());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                ColumnInfo parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (ColumnInfo) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private Object name_ = "";
            /** <code>optional string name = 1;</code> */
            public boolean hasName() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /** <code>optional string name = 1;</code> */
            public String getName() {
                Object ref = name_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        name_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /** <code>optional string name = 1;</code> */
            public com.google.protobuf.ByteString getNameBytes() {
                Object ref = name_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                    name_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /** <code>optional string name = 1;</code> */
            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                name_ = value;
                onChanged();
                return this;
            }
            /** <code>optional string name = 1;</code> */
            public Builder clearName() {
                bitField0_ = (bitField0_ & ~0x00000001);
                name_ = getDefaultInstance().getName();
                onChanged();
                return this;
            }
            /** <code>optional string name = 1;</code> */
            public Builder setNameBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                name_ = value;
                onChanged();
                return this;
            }

            private Object mysqlType_ = "";
            /**
             *
             *
             * <pre>
             * lower case column field type in mysql
             * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
             * for numeric type: int bigint smallint tinyint float double decimal bit
             * for string type: text longtext mediumtext char tinytext varchar
             * blob longblog mediumblog binary tinyblob varbinary
             * enum set
             * for json type: json
             * </pre>
             *
             * <code>optional string mysql_type = 2;</code>
             */
            public boolean hasMysqlType() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             *
             *
             * <pre>
             * lower case column field type in mysql
             * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
             * for numeric type: int bigint smallint tinyint float double decimal bit
             * for string type: text longtext mediumtext char tinytext varchar
             * blob longblog mediumblog binary tinyblob varbinary
             * enum set
             * for json type: json
             * </pre>
             *
             * <code>optional string mysql_type = 2;</code>
             */
            public String getMysqlType() {
                Object ref = mysqlType_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        mysqlType_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             *
             *
             * <pre>
             * lower case column field type in mysql
             * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
             * for numeric type: int bigint smallint tinyint float double decimal bit
             * for string type: text longtext mediumtext char tinytext varchar
             * blob longblog mediumblog binary tinyblob varbinary
             * enum set
             * for json type: json
             * </pre>
             *
             * <code>optional string mysql_type = 2;</code>
             */
            public com.google.protobuf.ByteString getMysqlTypeBytes() {
                Object ref = mysqlType_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                    mysqlType_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             *
             *
             * <pre>
             * lower case column field type in mysql
             * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
             * for numeric type: int bigint smallint tinyint float double decimal bit
             * for string type: text longtext mediumtext char tinytext varchar
             * blob longblog mediumblog binary tinyblob varbinary
             * enum set
             * for json type: json
             * </pre>
             *
             * <code>optional string mysql_type = 2;</code>
             */
            public Builder setMysqlType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                mysqlType_ = value;
                onChanged();
                return this;
            }
            /**
             *
             *
             * <pre>
             * lower case column field type in mysql
             * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
             * for numeric type: int bigint smallint tinyint float double decimal bit
             * for string type: text longtext mediumtext char tinytext varchar
             * blob longblog mediumblog binary tinyblob varbinary
             * enum set
             * for json type: json
             * </pre>
             *
             * <code>optional string mysql_type = 2;</code>
             */
            public Builder clearMysqlType() {
                bitField0_ = (bitField0_ & ~0x00000002);
                mysqlType_ = getDefaultInstance().getMysqlType();
                onChanged();
                return this;
            }
            /**
             *
             *
             * <pre>
             * lower case column field type in mysql
             * https://dev.mysql.com/doc/refman/8.0/en/data-types.html
             * for numeric type: int bigint smallint tinyint float double decimal bit
             * for string type: text longtext mediumtext char tinytext varchar
             * blob longblog mediumblog binary tinyblob varbinary
             * enum set
             * for json type: json
             * </pre>
             *
             * <code>optional string mysql_type = 2;</code>
             */
            public Builder setMysqlTypeBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                mysqlType_ = value;
                onChanged();
                return this;
            }

            private boolean isPrimaryKey_;
            /** <code>optional bool is_primary_key = 3;</code> */
            public boolean hasIsPrimaryKey() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }
            /** <code>optional bool is_primary_key = 3;</code> */
            public boolean getIsPrimaryKey() {
                return isPrimaryKey_;
            }
            /** <code>optional bool is_primary_key = 3;</code> */
            public Builder setIsPrimaryKey(boolean value) {
                bitField0_ |= 0x00000004;
                isPrimaryKey_ = value;
                onChanged();
                return this;
            }
            /** <code>optional bool is_primary_key = 3;</code> */
            public Builder clearIsPrimaryKey() {
                bitField0_ = (bitField0_ & ~0x00000004);
                isPrimaryKey_ = false;
                onChanged();
                return this;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:slave.binlog.ColumnInfo)
        }

        // @@protoc_insertion_point(class_scope:slave.binlog.ColumnInfo)
        private static final ColumnInfo DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new ColumnInfo();
        }

        public static ColumnInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<ColumnInfo> PARSER =
                new com.google.protobuf.AbstractParser<ColumnInfo>() {
                    @Override
                    public ColumnInfo parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new ColumnInfo(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<ColumnInfo> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<ColumnInfo> getParserForType() {
            return PARSER;
        }

        @Override
        public ColumnInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface RowOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:slave.binlog.Row)
            com.google.protobuf.MessageOrBuilder {

        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        java.util.List<Column> getColumnsList();
        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        Column getColumns(int index);
        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        int getColumnsCount();
        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        java.util.List<? extends ColumnOrBuilder> getColumnsOrBuilderList();
        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        ColumnOrBuilder getColumnsOrBuilder(int index);
    }
    /** Protobuf type {@code slave.binlog.Row} */
    public static final class Row extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:slave.binlog.Row)
            RowOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use Row.newBuilder() to construct.
        private Row(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private Row() {
            columns_ = java.util.Collections.emptyList();
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Row(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            {
                                if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                                    columns_ = new java.util.ArrayList<Column>();
                                    mutable_bitField0_ |= 0x00000001;
                                }
                                columns_.add(input.readMessage(Column.PARSER, extensionRegistry));
                                break;
                            }
                        default:
                            {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                    columns_ = java.util.Collections.unmodifiableList(columns_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return BinLog.internal_static_slave_binlog_Row_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return BinLog.internal_static_slave_binlog_Row_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(Row.class, Builder.class);
        }

        public static final int COLUMNS_FIELD_NUMBER = 1;
        private java.util.List<Column> columns_;
        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        public java.util.List<Column> getColumnsList() {
            return columns_;
        }
        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        public java.util.List<? extends ColumnOrBuilder> getColumnsOrBuilderList() {
            return columns_;
        }
        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        public int getColumnsCount() {
            return columns_.size();
        }
        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        public Column getColumns(int index) {
            return columns_.get(index);
        }
        /** <code>repeated .slave.binlog.Column columns = 1;</code> */
        public ColumnOrBuilder getColumnsOrBuilder(int index) {
            return columns_.get(index);
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            for (int i = 0; i < columns_.size(); i++) {
                output.writeMessage(1, columns_.get(i));
            }
            unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            for (int i = 0; i < columns_.size(); i++) {
                size +=
                        com.google.protobuf.CodedOutputStream.computeMessageSize(
                                1, columns_.get(i));
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Row)) {
                return super.equals(obj);
            }
            Row other = (Row) obj;

            boolean result = true;
            result = result && getColumnsList().equals(other.getColumnsList());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (getColumnsCount() > 0) {
                hash = (37 * hash) + COLUMNS_FIELD_NUMBER;
                hash = (53 * hash) + getColumnsList().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static Row parseFrom(java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Row parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Row parseFrom(com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Row parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Row parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Row parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Row parseFrom(java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Row parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static Row parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input);
        }

        public static Row parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static Row parseFrom(com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Row parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Row prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /** Protobuf type {@code slave.binlog.Row} */
        public static final class Builder
                extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:slave.binlog.Row)
                RowOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return BinLog.internal_static_slave_binlog_Row_descriptor;
            }

            @Override
            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return BinLog.internal_static_slave_binlog_Row_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(Row.class, Builder.class);
            }

            // Construct using com.fcbox.move.bean.BinLog.Row.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getColumnsFieldBuilder();
                }
            }

            @Override
            public Builder clear() {
                super.clear();
                if (columnsBuilder_ == null) {
                    columns_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                } else {
                    columnsBuilder_.clear();
                }
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return BinLog.internal_static_slave_binlog_Row_descriptor;
            }

            @Override
            public Row getDefaultInstanceForType() {
                return Row.getDefaultInstance();
            }

            @Override
            public Row build() {
                Row result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public Row buildPartial() {
                Row result = new Row(this);
                int from_bitField0_ = bitField0_;
                if (columnsBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) == 0x00000001)) {
                        columns_ = java.util.Collections.unmodifiableList(columns_);
                        bitField0_ = (bitField0_ & ~0x00000001);
                    }
                    result.columns_ = columns_;
                } else {
                    result.columns_ = columnsBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override
            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override
            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index,
                    Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Row) {
                    return mergeFrom((Row) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(Row other) {
                if (other == Row.getDefaultInstance()) return this;
                if (columnsBuilder_ == null) {
                    if (!other.columns_.isEmpty()) {
                        if (columns_.isEmpty()) {
                            columns_ = other.columns_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                        } else {
                            ensureColumnsIsMutable();
                            columns_.addAll(other.columns_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.columns_.isEmpty()) {
                        if (columnsBuilder_.isEmpty()) {
                            columnsBuilder_.dispose();
                            columnsBuilder_ = null;
                            columns_ = other.columns_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                            columnsBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                                            ? getColumnsFieldBuilder()
                                            : null;
                        } else {
                            columnsBuilder_.addAllMessages(other.columns_);
                        }
                    }
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                Row parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (Row) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.util.List<Column> columns_ = java.util.Collections.emptyList();

            private void ensureColumnsIsMutable() {
                if (!((bitField0_ & 0x00000001) == 0x00000001)) {
                    columns_ = new java.util.ArrayList<Column>(columns_);
                    bitField0_ |= 0x00000001;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                            Column, Column.Builder, ColumnOrBuilder>
                    columnsBuilder_;

            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public java.util.List<Column> getColumnsList() {
                if (columnsBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(columns_);
                } else {
                    return columnsBuilder_.getMessageList();
                }
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public int getColumnsCount() {
                if (columnsBuilder_ == null) {
                    return columns_.size();
                } else {
                    return columnsBuilder_.getCount();
                }
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Column getColumns(int index) {
                if (columnsBuilder_ == null) {
                    return columns_.get(index);
                } else {
                    return columnsBuilder_.getMessage(index);
                }
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Builder setColumns(int index, Column value) {
                if (columnsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureColumnsIsMutable();
                    columns_.set(index, value);
                    onChanged();
                } else {
                    columnsBuilder_.setMessage(index, value);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Builder setColumns(int index, Column.Builder builderForValue) {
                if (columnsBuilder_ == null) {
                    ensureColumnsIsMutable();
                    columns_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    columnsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Builder addColumns(Column value) {
                if (columnsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureColumnsIsMutable();
                    columns_.add(value);
                    onChanged();
                } else {
                    columnsBuilder_.addMessage(value);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Builder addColumns(int index, Column value) {
                if (columnsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureColumnsIsMutable();
                    columns_.add(index, value);
                    onChanged();
                } else {
                    columnsBuilder_.addMessage(index, value);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Builder addColumns(Column.Builder builderForValue) {
                if (columnsBuilder_ == null) {
                    ensureColumnsIsMutable();
                    columns_.add(builderForValue.build());
                    onChanged();
                } else {
                    columnsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Builder addColumns(int index, Column.Builder builderForValue) {
                if (columnsBuilder_ == null) {
                    ensureColumnsIsMutable();
                    columns_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    columnsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Builder addAllColumns(Iterable<? extends Column> values) {
                if (columnsBuilder_ == null) {
                    ensureColumnsIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, columns_);
                    onChanged();
                } else {
                    columnsBuilder_.addAllMessages(values);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Builder clearColumns() {
                if (columnsBuilder_ == null) {
                    columns_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                    onChanged();
                } else {
                    columnsBuilder_.clear();
                }
                return this;
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Builder removeColumns(int index) {
                if (columnsBuilder_ == null) {
                    ensureColumnsIsMutable();
                    columns_.remove(index);
                    onChanged();
                } else {
                    columnsBuilder_.remove(index);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Column.Builder getColumnsBuilder(int index) {
                return getColumnsFieldBuilder().getBuilder(index);
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public ColumnOrBuilder getColumnsOrBuilder(int index) {
                if (columnsBuilder_ == null) {
                    return columns_.get(index);
                } else {
                    return columnsBuilder_.getMessageOrBuilder(index);
                }
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public java.util.List<? extends ColumnOrBuilder> getColumnsOrBuilderList() {
                if (columnsBuilder_ != null) {
                    return columnsBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(columns_);
                }
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Column.Builder addColumnsBuilder() {
                return getColumnsFieldBuilder().addBuilder(Column.getDefaultInstance());
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public Column.Builder addColumnsBuilder(int index) {
                return getColumnsFieldBuilder().addBuilder(index, Column.getDefaultInstance());
            }
            /** <code>repeated .slave.binlog.Column columns = 1;</code> */
            public java.util.List<Column.Builder> getColumnsBuilderList() {
                return getColumnsFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                            Column, Column.Builder, ColumnOrBuilder>
                    getColumnsFieldBuilder() {
                if (columnsBuilder_ == null) {
                    columnsBuilder_ =
                            new com.google.protobuf.RepeatedFieldBuilderV3<
                                    Column, Column.Builder, ColumnOrBuilder>(
                                    columns_,
                                    ((bitField0_ & 0x00000001) == 0x00000001),
                                    getParentForChildren(),
                                    isClean());
                    columns_ = null;
                }
                return columnsBuilder_;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:slave.binlog.Row)
        }

        // @@protoc_insertion_point(class_scope:slave.binlog.Row)
        private static final Row DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new Row();
        }

        public static Row getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<Row> PARSER =
                new com.google.protobuf.AbstractParser<Row>() {
                    @Override
                    public Row parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new Row(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<Row> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<Row> getParserForType() {
            return PARSER;
        }

        @Override
        public Row getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface TableOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:slave.binlog.Table)
            com.google.protobuf.MessageOrBuilder {

        /** <code>optional string schema_name = 1;</code> */
        boolean hasSchemaName();
        /** <code>optional string schema_name = 1;</code> */
        String getSchemaName();
        /** <code>optional string schema_name = 1;</code> */
        com.google.protobuf.ByteString getSchemaNameBytes();

        /** <code>optional string table_name = 2;</code> */
        boolean hasTableName();
        /** <code>optional string table_name = 2;</code> */
        String getTableName();
        /** <code>optional string table_name = 2;</code> */
        com.google.protobuf.ByteString getTableNameBytes();

        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        java.util.List<ColumnInfo> getColumnInfoList();
        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        ColumnInfo getColumnInfo(int index);
        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        int getColumnInfoCount();
        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        java.util.List<? extends ColumnInfoOrBuilder> getColumnInfoOrBuilderList();
        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        ColumnInfoOrBuilder getColumnInfoOrBuilder(int index);

        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        java.util.List<TableMutation> getMutationsList();
        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        TableMutation getMutations(int index);
        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        int getMutationsCount();
        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        java.util.List<? extends TableMutationOrBuilder> getMutationsOrBuilderList();
        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        TableMutationOrBuilder getMutationsOrBuilder(int index);
    }
    /**
     *
     *
     * <pre>
     *  Table contains mutations in a table.
     * </pre>
     *
     * Protobuf type {@code slave.binlog.Table}
     */
    public static final class Table extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:slave.binlog.Table)
            TableOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use Table.newBuilder() to construct.
        private Table(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private Table() {
            schemaName_ = "";
            tableName_ = "";
            columnInfo_ = java.util.Collections.emptyList();
            mutations_ = java.util.Collections.emptyList();
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Table(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000001;
                                schemaName_ = bs;
                                break;
                            }
                        case 18:
                            {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000002;
                                tableName_ = bs;
                                break;
                            }
                        case 26:
                            {
                                if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                                    columnInfo_ = new java.util.ArrayList<ColumnInfo>();
                                    mutable_bitField0_ |= 0x00000004;
                                }
                                columnInfo_.add(
                                        input.readMessage(ColumnInfo.PARSER, extensionRegistry));
                                break;
                            }
                        case 34:
                            {
                                if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                                    mutations_ = new java.util.ArrayList<TableMutation>();
                                    mutable_bitField0_ |= 0x00000008;
                                }
                                mutations_.add(
                                        input.readMessage(TableMutation.PARSER, extensionRegistry));
                                break;
                            }
                        default:
                            {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                    columnInfo_ = java.util.Collections.unmodifiableList(columnInfo_);
                }
                if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                    mutations_ = java.util.Collections.unmodifiableList(mutations_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return BinLog.internal_static_slave_binlog_Table_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return BinLog.internal_static_slave_binlog_Table_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(Table.class, Builder.class);
        }

        private int bitField0_;
        public static final int SCHEMA_NAME_FIELD_NUMBER = 1;
        private volatile Object schemaName_;
        /** <code>optional string schema_name = 1;</code> */
        public boolean hasSchemaName() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /** <code>optional string schema_name = 1;</code> */
        public String getSchemaName() {
            Object ref = schemaName_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    schemaName_ = s;
                }
                return s;
            }
        }
        /** <code>optional string schema_name = 1;</code> */
        public com.google.protobuf.ByteString getSchemaNameBytes() {
            Object ref = schemaName_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                schemaName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int TABLE_NAME_FIELD_NUMBER = 2;
        private volatile Object tableName_;
        /** <code>optional string table_name = 2;</code> */
        public boolean hasTableName() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /** <code>optional string table_name = 2;</code> */
        public String getTableName() {
            Object ref = tableName_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    tableName_ = s;
                }
                return s;
            }
        }
        /** <code>optional string table_name = 2;</code> */
        public com.google.protobuf.ByteString getTableNameBytes() {
            Object ref = tableName_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                tableName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int COLUMN_INFO_FIELD_NUMBER = 3;
        private java.util.List<ColumnInfo> columnInfo_;
        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        public java.util.List<ColumnInfo> getColumnInfoList() {
            return columnInfo_;
        }
        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        public java.util.List<? extends ColumnInfoOrBuilder> getColumnInfoOrBuilderList() {
            return columnInfo_;
        }
        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        public int getColumnInfoCount() {
            return columnInfo_.size();
        }
        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        public ColumnInfo getColumnInfo(int index) {
            return columnInfo_.get(index);
        }
        /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
        public ColumnInfoOrBuilder getColumnInfoOrBuilder(int index) {
            return columnInfo_.get(index);
        }

        public static final int MUTATIONS_FIELD_NUMBER = 4;
        private java.util.List<TableMutation> mutations_;
        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        public java.util.List<TableMutation> getMutationsList() {
            return mutations_;
        }
        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        public java.util.List<? extends TableMutationOrBuilder> getMutationsOrBuilderList() {
            return mutations_;
        }
        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        public int getMutationsCount() {
            return mutations_.size();
        }
        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        public TableMutation getMutations(int index) {
            return mutations_.get(index);
        }
        /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
        public TableMutationOrBuilder getMutationsOrBuilder(int index) {
            return mutations_.get(index);
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            for (int i = 0; i < getMutationsCount(); i++) {
                if (!getMutations(i).isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, schemaName_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, tableName_);
            }
            for (int i = 0; i < columnInfo_.size(); i++) {
                output.writeMessage(3, columnInfo_.get(i));
            }
            for (int i = 0; i < mutations_.size(); i++) {
                output.writeMessage(4, mutations_.get(i));
            }
            unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, schemaName_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, tableName_);
            }
            for (int i = 0; i < columnInfo_.size(); i++) {
                size +=
                        com.google.protobuf.CodedOutputStream.computeMessageSize(
                                3, columnInfo_.get(i));
            }
            for (int i = 0; i < mutations_.size(); i++) {
                size +=
                        com.google.protobuf.CodedOutputStream.computeMessageSize(
                                4, mutations_.get(i));
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Table)) {
                return super.equals(obj);
            }
            Table other = (Table) obj;

            boolean result = true;
            result = result && (hasSchemaName() == other.hasSchemaName());
            if (hasSchemaName()) {
                result = result && getSchemaName().equals(other.getSchemaName());
            }
            result = result && (hasTableName() == other.hasTableName());
            if (hasTableName()) {
                result = result && getTableName().equals(other.getTableName());
            }
            result = result && getColumnInfoList().equals(other.getColumnInfoList());
            result = result && getMutationsList().equals(other.getMutationsList());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasSchemaName()) {
                hash = (37 * hash) + SCHEMA_NAME_FIELD_NUMBER;
                hash = (53 * hash) + getSchemaName().hashCode();
            }
            if (hasTableName()) {
                hash = (37 * hash) + TABLE_NAME_FIELD_NUMBER;
                hash = (53 * hash) + getTableName().hashCode();
            }
            if (getColumnInfoCount() > 0) {
                hash = (37 * hash) + COLUMN_INFO_FIELD_NUMBER;
                hash = (53 * hash) + getColumnInfoList().hashCode();
            }
            if (getMutationsCount() > 0) {
                hash = (37 * hash) + MUTATIONS_FIELD_NUMBER;
                hash = (53 * hash) + getMutationsList().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static Table parseFrom(java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Table parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Table parseFrom(com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Table parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Table parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Table parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Table parseFrom(java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Table parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static Table parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input);
        }

        public static Table parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static Table parseFrom(com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Table parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Table prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         *
         *
         * <pre>
         *  Table contains mutations in a table.
         * </pre>
         *
         * Protobuf type {@code slave.binlog.Table}
         */
        public static final class Builder
                extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:slave.binlog.Table)
                TableOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return BinLog.internal_static_slave_binlog_Table_descriptor;
            }

            @Override
            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return BinLog.internal_static_slave_binlog_Table_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(Table.class, Builder.class);
            }

            // Construct using com.fcbox.move.bean.BinLog.Table.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getColumnInfoFieldBuilder();
                    getMutationsFieldBuilder();
                }
            }

            @Override
            public Builder clear() {
                super.clear();
                schemaName_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                tableName_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                if (columnInfoBuilder_ == null) {
                    columnInfo_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000004);
                } else {
                    columnInfoBuilder_.clear();
                }
                if (mutationsBuilder_ == null) {
                    mutations_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000008);
                } else {
                    mutationsBuilder_.clear();
                }
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return BinLog.internal_static_slave_binlog_Table_descriptor;
            }

            @Override
            public Table getDefaultInstanceForType() {
                return Table.getDefaultInstance();
            }

            @Override
            public Table build() {
                Table result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public Table buildPartial() {
                Table result = new Table(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.schemaName_ = schemaName_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.tableName_ = tableName_;
                if (columnInfoBuilder_ == null) {
                    if (((bitField0_ & 0x00000004) == 0x00000004)) {
                        columnInfo_ = java.util.Collections.unmodifiableList(columnInfo_);
                        bitField0_ = (bitField0_ & ~0x00000004);
                    }
                    result.columnInfo_ = columnInfo_;
                } else {
                    result.columnInfo_ = columnInfoBuilder_.build();
                }
                if (mutationsBuilder_ == null) {
                    if (((bitField0_ & 0x00000008) == 0x00000008)) {
                        mutations_ = java.util.Collections.unmodifiableList(mutations_);
                        bitField0_ = (bitField0_ & ~0x00000008);
                    }
                    result.mutations_ = mutations_;
                } else {
                    result.mutations_ = mutationsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override
            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override
            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index,
                    Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Table) {
                    return mergeFrom((Table) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(Table other) {
                if (other == Table.getDefaultInstance()) return this;
                if (other.hasSchemaName()) {
                    bitField0_ |= 0x00000001;
                    schemaName_ = other.schemaName_;
                    onChanged();
                }
                if (other.hasTableName()) {
                    bitField0_ |= 0x00000002;
                    tableName_ = other.tableName_;
                    onChanged();
                }
                if (columnInfoBuilder_ == null) {
                    if (!other.columnInfo_.isEmpty()) {
                        if (columnInfo_.isEmpty()) {
                            columnInfo_ = other.columnInfo_;
                            bitField0_ = (bitField0_ & ~0x00000004);
                        } else {
                            ensureColumnInfoIsMutable();
                            columnInfo_.addAll(other.columnInfo_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.columnInfo_.isEmpty()) {
                        if (columnInfoBuilder_.isEmpty()) {
                            columnInfoBuilder_.dispose();
                            columnInfoBuilder_ = null;
                            columnInfo_ = other.columnInfo_;
                            bitField0_ = (bitField0_ & ~0x00000004);
                            columnInfoBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                                            ? getColumnInfoFieldBuilder()
                                            : null;
                        } else {
                            columnInfoBuilder_.addAllMessages(other.columnInfo_);
                        }
                    }
                }
                if (mutationsBuilder_ == null) {
                    if (!other.mutations_.isEmpty()) {
                        if (mutations_.isEmpty()) {
                            mutations_ = other.mutations_;
                            bitField0_ = (bitField0_ & ~0x00000008);
                        } else {
                            ensureMutationsIsMutable();
                            mutations_.addAll(other.mutations_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.mutations_.isEmpty()) {
                        if (mutationsBuilder_.isEmpty()) {
                            mutationsBuilder_.dispose();
                            mutationsBuilder_ = null;
                            mutations_ = other.mutations_;
                            bitField0_ = (bitField0_ & ~0x00000008);
                            mutationsBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                                            ? getMutationsFieldBuilder()
                                            : null;
                        } else {
                            mutationsBuilder_.addAllMessages(other.mutations_);
                        }
                    }
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i = 0; i < getMutationsCount(); i++) {
                    if (!getMutations(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                Table parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (Table) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private Object schemaName_ = "";
            /** <code>optional string schema_name = 1;</code> */
            public boolean hasSchemaName() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /** <code>optional string schema_name = 1;</code> */
            public String getSchemaName() {
                Object ref = schemaName_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        schemaName_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /** <code>optional string schema_name = 1;</code> */
            public com.google.protobuf.ByteString getSchemaNameBytes() {
                Object ref = schemaName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                    schemaName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /** <code>optional string schema_name = 1;</code> */
            public Builder setSchemaName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                schemaName_ = value;
                onChanged();
                return this;
            }
            /** <code>optional string schema_name = 1;</code> */
            public Builder clearSchemaName() {
                bitField0_ = (bitField0_ & ~0x00000001);
                schemaName_ = getDefaultInstance().getSchemaName();
                onChanged();
                return this;
            }
            /** <code>optional string schema_name = 1;</code> */
            public Builder setSchemaNameBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                schemaName_ = value;
                onChanged();
                return this;
            }

            private Object tableName_ = "";
            /** <code>optional string table_name = 2;</code> */
            public boolean hasTableName() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /** <code>optional string table_name = 2;</code> */
            public String getTableName() {
                Object ref = tableName_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        tableName_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /** <code>optional string table_name = 2;</code> */
            public com.google.protobuf.ByteString getTableNameBytes() {
                Object ref = tableName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                    tableName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /** <code>optional string table_name = 2;</code> */
            public Builder setTableName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                tableName_ = value;
                onChanged();
                return this;
            }
            /** <code>optional string table_name = 2;</code> */
            public Builder clearTableName() {
                bitField0_ = (bitField0_ & ~0x00000002);
                tableName_ = getDefaultInstance().getTableName();
                onChanged();
                return this;
            }
            /** <code>optional string table_name = 2;</code> */
            public Builder setTableNameBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                tableName_ = value;
                onChanged();
                return this;
            }

            private java.util.List<ColumnInfo> columnInfo_ = java.util.Collections.emptyList();

            private void ensureColumnInfoIsMutable() {
                if (!((bitField0_ & 0x00000004) == 0x00000004)) {
                    columnInfo_ = new java.util.ArrayList<ColumnInfo>(columnInfo_);
                    bitField0_ |= 0x00000004;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                            ColumnInfo, ColumnInfo.Builder, ColumnInfoOrBuilder>
                    columnInfoBuilder_;

            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public java.util.List<ColumnInfo> getColumnInfoList() {
                if (columnInfoBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(columnInfo_);
                } else {
                    return columnInfoBuilder_.getMessageList();
                }
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public int getColumnInfoCount() {
                if (columnInfoBuilder_ == null) {
                    return columnInfo_.size();
                } else {
                    return columnInfoBuilder_.getCount();
                }
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public ColumnInfo getColumnInfo(int index) {
                if (columnInfoBuilder_ == null) {
                    return columnInfo_.get(index);
                } else {
                    return columnInfoBuilder_.getMessage(index);
                }
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public Builder setColumnInfo(int index, ColumnInfo value) {
                if (columnInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureColumnInfoIsMutable();
                    columnInfo_.set(index, value);
                    onChanged();
                } else {
                    columnInfoBuilder_.setMessage(index, value);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public Builder setColumnInfo(int index, ColumnInfo.Builder builderForValue) {
                if (columnInfoBuilder_ == null) {
                    ensureColumnInfoIsMutable();
                    columnInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    columnInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public Builder addColumnInfo(ColumnInfo value) {
                if (columnInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureColumnInfoIsMutable();
                    columnInfo_.add(value);
                    onChanged();
                } else {
                    columnInfoBuilder_.addMessage(value);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public Builder addColumnInfo(int index, ColumnInfo value) {
                if (columnInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureColumnInfoIsMutable();
                    columnInfo_.add(index, value);
                    onChanged();
                } else {
                    columnInfoBuilder_.addMessage(index, value);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public Builder addColumnInfo(ColumnInfo.Builder builderForValue) {
                if (columnInfoBuilder_ == null) {
                    ensureColumnInfoIsMutable();
                    columnInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    columnInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public Builder addColumnInfo(int index, ColumnInfo.Builder builderForValue) {
                if (columnInfoBuilder_ == null) {
                    ensureColumnInfoIsMutable();
                    columnInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    columnInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public Builder addAllColumnInfo(Iterable<? extends ColumnInfo> values) {
                if (columnInfoBuilder_ == null) {
                    ensureColumnInfoIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, columnInfo_);
                    onChanged();
                } else {
                    columnInfoBuilder_.addAllMessages(values);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public Builder clearColumnInfo() {
                if (columnInfoBuilder_ == null) {
                    columnInfo_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000004);
                    onChanged();
                } else {
                    columnInfoBuilder_.clear();
                }
                return this;
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public Builder removeColumnInfo(int index) {
                if (columnInfoBuilder_ == null) {
                    ensureColumnInfoIsMutable();
                    columnInfo_.remove(index);
                    onChanged();
                } else {
                    columnInfoBuilder_.remove(index);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public ColumnInfo.Builder getColumnInfoBuilder(int index) {
                return getColumnInfoFieldBuilder().getBuilder(index);
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public ColumnInfoOrBuilder getColumnInfoOrBuilder(int index) {
                if (columnInfoBuilder_ == null) {
                    return columnInfo_.get(index);
                } else {
                    return columnInfoBuilder_.getMessageOrBuilder(index);
                }
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public java.util.List<? extends ColumnInfoOrBuilder> getColumnInfoOrBuilderList() {
                if (columnInfoBuilder_ != null) {
                    return columnInfoBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(columnInfo_);
                }
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public ColumnInfo.Builder addColumnInfoBuilder() {
                return getColumnInfoFieldBuilder().addBuilder(ColumnInfo.getDefaultInstance());
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public ColumnInfo.Builder addColumnInfoBuilder(int index) {
                return getColumnInfoFieldBuilder()
                        .addBuilder(index, ColumnInfo.getDefaultInstance());
            }
            /** <code>repeated .slave.binlog.ColumnInfo column_info = 3;</code> */
            public java.util.List<ColumnInfo.Builder> getColumnInfoBuilderList() {
                return getColumnInfoFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                            ColumnInfo, ColumnInfo.Builder, ColumnInfoOrBuilder>
                    getColumnInfoFieldBuilder() {
                if (columnInfoBuilder_ == null) {
                    columnInfoBuilder_ =
                            new com.google.protobuf.RepeatedFieldBuilderV3<
                                    ColumnInfo, ColumnInfo.Builder, ColumnInfoOrBuilder>(
                                    columnInfo_,
                                    ((bitField0_ & 0x00000004) == 0x00000004),
                                    getParentForChildren(),
                                    isClean());
                    columnInfo_ = null;
                }
                return columnInfoBuilder_;
            }

            private java.util.List<TableMutation> mutations_ = java.util.Collections.emptyList();

            private void ensureMutationsIsMutable() {
                if (!((bitField0_ & 0x00000008) == 0x00000008)) {
                    mutations_ = new java.util.ArrayList<TableMutation>(mutations_);
                    bitField0_ |= 0x00000008;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                            TableMutation, TableMutation.Builder, TableMutationOrBuilder>
                    mutationsBuilder_;

            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public java.util.List<TableMutation> getMutationsList() {
                if (mutationsBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(mutations_);
                } else {
                    return mutationsBuilder_.getMessageList();
                }
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public int getMutationsCount() {
                if (mutationsBuilder_ == null) {
                    return mutations_.size();
                } else {
                    return mutationsBuilder_.getCount();
                }
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public TableMutation getMutations(int index) {
                if (mutationsBuilder_ == null) {
                    return mutations_.get(index);
                } else {
                    return mutationsBuilder_.getMessage(index);
                }
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public Builder setMutations(int index, TableMutation value) {
                if (mutationsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMutationsIsMutable();
                    mutations_.set(index, value);
                    onChanged();
                } else {
                    mutationsBuilder_.setMessage(index, value);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public Builder setMutations(int index, TableMutation.Builder builderForValue) {
                if (mutationsBuilder_ == null) {
                    ensureMutationsIsMutable();
                    mutations_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    mutationsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public Builder addMutations(TableMutation value) {
                if (mutationsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMutationsIsMutable();
                    mutations_.add(value);
                    onChanged();
                } else {
                    mutationsBuilder_.addMessage(value);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public Builder addMutations(int index, TableMutation value) {
                if (mutationsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMutationsIsMutable();
                    mutations_.add(index, value);
                    onChanged();
                } else {
                    mutationsBuilder_.addMessage(index, value);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public Builder addMutations(TableMutation.Builder builderForValue) {
                if (mutationsBuilder_ == null) {
                    ensureMutationsIsMutable();
                    mutations_.add(builderForValue.build());
                    onChanged();
                } else {
                    mutationsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public Builder addMutations(int index, TableMutation.Builder builderForValue) {
                if (mutationsBuilder_ == null) {
                    ensureMutationsIsMutable();
                    mutations_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    mutationsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public Builder addAllMutations(Iterable<? extends TableMutation> values) {
                if (mutationsBuilder_ == null) {
                    ensureMutationsIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, mutations_);
                    onChanged();
                } else {
                    mutationsBuilder_.addAllMessages(values);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public Builder clearMutations() {
                if (mutationsBuilder_ == null) {
                    mutations_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000008);
                    onChanged();
                } else {
                    mutationsBuilder_.clear();
                }
                return this;
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public Builder removeMutations(int index) {
                if (mutationsBuilder_ == null) {
                    ensureMutationsIsMutable();
                    mutations_.remove(index);
                    onChanged();
                } else {
                    mutationsBuilder_.remove(index);
                }
                return this;
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public TableMutation.Builder getMutationsBuilder(int index) {
                return getMutationsFieldBuilder().getBuilder(index);
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public TableMutationOrBuilder getMutationsOrBuilder(int index) {
                if (mutationsBuilder_ == null) {
                    return mutations_.get(index);
                } else {
                    return mutationsBuilder_.getMessageOrBuilder(index);
                }
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public java.util.List<? extends TableMutationOrBuilder> getMutationsOrBuilderList() {
                if (mutationsBuilder_ != null) {
                    return mutationsBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(mutations_);
                }
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public TableMutation.Builder addMutationsBuilder() {
                return getMutationsFieldBuilder().addBuilder(TableMutation.getDefaultInstance());
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public TableMutation.Builder addMutationsBuilder(int index) {
                return getMutationsFieldBuilder()
                        .addBuilder(index, TableMutation.getDefaultInstance());
            }
            /** <code>repeated .slave.binlog.TableMutation mutations = 4;</code> */
            public java.util.List<TableMutation.Builder> getMutationsBuilderList() {
                return getMutationsFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                            TableMutation, TableMutation.Builder, TableMutationOrBuilder>
                    getMutationsFieldBuilder() {
                if (mutationsBuilder_ == null) {
                    mutationsBuilder_ =
                            new com.google.protobuf.RepeatedFieldBuilderV3<
                                    TableMutation, TableMutation.Builder, TableMutationOrBuilder>(
                                    mutations_,
                                    ((bitField0_ & 0x00000008) == 0x00000008),
                                    getParentForChildren(),
                                    isClean());
                    mutations_ = null;
                }
                return mutationsBuilder_;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:slave.binlog.Table)
        }

        // @@protoc_insertion_point(class_scope:slave.binlog.Table)
        private static final Table DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new Table();
        }

        public static Table getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<Table> PARSER =
                new com.google.protobuf.AbstractParser<Table>() {
                    @Override
                    public Table parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new Table(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<Table> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<Table> getParserForType() {
            return PARSER;
        }

        @Override
        public Table getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface TableMutationOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:slave.binlog.TableMutation)
            com.google.protobuf.MessageOrBuilder {

        /** <code>required .slave.binlog.MutationType type = 1;</code> */
        boolean hasType();
        /** <code>required .slave.binlog.MutationType type = 1;</code> */
        MutationType getType();

        /** <code>required .slave.binlog.Row row = 2;</code> */
        boolean hasRow();
        /** <code>required .slave.binlog.Row row = 2;</code> */
        Row getRow();
        /** <code>required .slave.binlog.Row row = 2;</code> */
        RowOrBuilder getRowOrBuilder();

        /**
         *
         *
         * <pre>
         * for Update MutationType only
         * </pre>
         *
         * <code>optional .slave.binlog.Row change_row = 3;</code>
         */
        boolean hasChangeRow();
        /**
         *
         *
         * <pre>
         * for Update MutationType only
         * </pre>
         *
         * <code>optional .slave.binlog.Row change_row = 3;</code>
         */
        Row getChangeRow();
        /**
         *
         *
         * <pre>
         * for Update MutationType only
         * </pre>
         *
         * <code>optional .slave.binlog.Row change_row = 3;</code>
         */
        RowOrBuilder getChangeRowOrBuilder();
    }
    /** Protobuf type {@code slave.binlog.TableMutation} */
    public static final class TableMutation extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:slave.binlog.TableMutation)
            TableMutationOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use TableMutation.newBuilder() to construct.
        private TableMutation(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private TableMutation() {
            type_ = 0;
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TableMutation(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            {
                                int rawValue = input.readEnum();
                                @SuppressWarnings("deprecation")
                                MutationType value = MutationType.valueOf(rawValue);
                                if (value == null) {
                                    unknownFields.mergeVarintField(1, rawValue);
                                } else {
                                    bitField0_ |= 0x00000001;
                                    type_ = rawValue;
                                }
                                break;
                            }
                        case 18:
                            {
                                Row.Builder subBuilder = null;
                                if (((bitField0_ & 0x00000002) == 0x00000002)) {
                                    subBuilder = row_.toBuilder();
                                }
                                row_ = input.readMessage(Row.PARSER, extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(row_);
                                    row_ = subBuilder.buildPartial();
                                }
                                bitField0_ |= 0x00000002;
                                break;
                            }
                        case 26:
                            {
                                Row.Builder subBuilder = null;
                                if (((bitField0_ & 0x00000004) == 0x00000004)) {
                                    subBuilder = changeRow_.toBuilder();
                                }
                                changeRow_ = input.readMessage(Row.PARSER, extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(changeRow_);
                                    changeRow_ = subBuilder.buildPartial();
                                }
                                bitField0_ |= 0x00000004;
                                break;
                            }
                        default:
                            {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return BinLog.internal_static_slave_binlog_TableMutation_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return BinLog.internal_static_slave_binlog_TableMutation_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(TableMutation.class, Builder.class);
        }

        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        /** <code>required .slave.binlog.MutationType type = 1;</code> */
        public boolean hasType() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /** <code>required .slave.binlog.MutationType type = 1;</code> */
        public MutationType getType() {
            @SuppressWarnings("deprecation")
            MutationType result = MutationType.valueOf(type_);
            return result == null ? MutationType.Insert : result;
        }

        public static final int ROW_FIELD_NUMBER = 2;
        private Row row_;
        /** <code>required .slave.binlog.Row row = 2;</code> */
        public boolean hasRow() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /** <code>required .slave.binlog.Row row = 2;</code> */
        public Row getRow() {
            return row_ == null ? Row.getDefaultInstance() : row_;
        }
        /** <code>required .slave.binlog.Row row = 2;</code> */
        public RowOrBuilder getRowOrBuilder() {
            return row_ == null ? Row.getDefaultInstance() : row_;
        }

        public static final int CHANGE_ROW_FIELD_NUMBER = 3;
        private Row changeRow_;
        /**
         *
         *
         * <pre>
         * for Update MutationType only
         * </pre>
         *
         * <code>optional .slave.binlog.Row change_row = 3;</code>
         */
        public boolean hasChangeRow() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }
        /**
         *
         *
         * <pre>
         * for Update MutationType only
         * </pre>
         *
         * <code>optional .slave.binlog.Row change_row = 3;</code>
         */
        public Row getChangeRow() {
            return changeRow_ == null ? Row.getDefaultInstance() : changeRow_;
        }
        /**
         *
         *
         * <pre>
         * for Update MutationType only
         * </pre>
         *
         * <code>optional .slave.binlog.Row change_row = 3;</code>
         */
        public RowOrBuilder getChangeRowOrBuilder() {
            return changeRow_ == null ? Row.getDefaultInstance() : changeRow_;
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasType()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasRow()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeEnum(1, type_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeMessage(2, getRow());
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeMessage(3, getChangeRow());
            }
            unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream.computeEnumSize(1, type_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getRow());
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, getChangeRow());
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TableMutation)) {
                return super.equals(obj);
            }
            TableMutation other = (TableMutation) obj;

            boolean result = true;
            result = result && (hasType() == other.hasType());
            if (hasType()) {
                result = result && type_ == other.type_;
            }
            result = result && (hasRow() == other.hasRow());
            if (hasRow()) {
                result = result && getRow().equals(other.getRow());
            }
            result = result && (hasChangeRow() == other.hasChangeRow());
            if (hasChangeRow()) {
                result = result && getChangeRow().equals(other.getChangeRow());
            }
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasType()) {
                hash = (37 * hash) + TYPE_FIELD_NUMBER;
                hash = (53 * hash) + type_;
            }
            if (hasRow()) {
                hash = (37 * hash) + ROW_FIELD_NUMBER;
                hash = (53 * hash) + getRow().hashCode();
            }
            if (hasChangeRow()) {
                hash = (37 * hash) + CHANGE_ROW_FIELD_NUMBER;
                hash = (53 * hash) + getChangeRow().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static TableMutation parseFrom(java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TableMutation parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TableMutation parseFrom(com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TableMutation parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TableMutation parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TableMutation parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TableMutation parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TableMutation parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static TableMutation parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input);
        }

        public static TableMutation parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static TableMutation parseFrom(com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TableMutation parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TableMutation prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /** Protobuf type {@code slave.binlog.TableMutation} */
        public static final class Builder
                extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:slave.binlog.TableMutation)
                TableMutationOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return BinLog.internal_static_slave_binlog_TableMutation_descriptor;
            }

            @Override
            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return BinLog.internal_static_slave_binlog_TableMutation_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(TableMutation.class, Builder.class);
            }

            // Construct using com.fcbox.move.bean.BinLog.TableMutation.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getRowFieldBuilder();
                    getChangeRowFieldBuilder();
                }
            }

            @Override
            public Builder clear() {
                super.clear();
                type_ = 0;
                bitField0_ = (bitField0_ & ~0x00000001);
                if (rowBuilder_ == null) {
                    row_ = null;
                } else {
                    rowBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                if (changeRowBuilder_ == null) {
                    changeRow_ = null;
                } else {
                    changeRowBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return BinLog.internal_static_slave_binlog_TableMutation_descriptor;
            }

            @Override
            public TableMutation getDefaultInstanceForType() {
                return TableMutation.getDefaultInstance();
            }

            @Override
            public TableMutation build() {
                TableMutation result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public TableMutation buildPartial() {
                TableMutation result = new TableMutation(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.type_ = type_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    if (rowBuilder_ == null) {
                        result.row_ = row_;
                    } else {
                        result.row_ = rowBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000002;
                }
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    if (changeRowBuilder_ == null) {
                        result.changeRow_ = changeRow_;
                    } else {
                        result.changeRow_ = changeRowBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000004;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override
            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override
            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index,
                    Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof TableMutation) {
                    return mergeFrom((TableMutation) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(TableMutation other) {
                if (other == TableMutation.getDefaultInstance()) return this;
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasRow()) {
                    mergeRow(other.getRow());
                }
                if (other.hasChangeRow()) {
                    mergeChangeRow(other.getChangeRow());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!hasType()) {
                    return false;
                }
                if (!hasRow()) {
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                TableMutation parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (TableMutation) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private int type_ = 0;
            /** <code>required .slave.binlog.MutationType type = 1;</code> */
            public boolean hasType() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /** <code>required .slave.binlog.MutationType type = 1;</code> */
            public MutationType getType() {
                @SuppressWarnings("deprecation")
                MutationType result = MutationType.valueOf(type_);
                return result == null ? MutationType.Insert : result;
            }
            /** <code>required .slave.binlog.MutationType type = 1;</code> */
            public Builder setType(MutationType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                type_ = value.getNumber();
                onChanged();
                return this;
            }
            /** <code>required .slave.binlog.MutationType type = 1;</code> */
            public Builder clearType() {
                bitField0_ = (bitField0_ & ~0x00000001);
                type_ = 0;
                onChanged();
                return this;
            }

            private Row row_;
            private com.google.protobuf.SingleFieldBuilderV3<Row, Row.Builder, RowOrBuilder>
                    rowBuilder_;
            /** <code>required .slave.binlog.Row row = 2;</code> */
            public boolean hasRow() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /** <code>required .slave.binlog.Row row = 2;</code> */
            public Row getRow() {
                if (rowBuilder_ == null) {
                    return row_ == null ? Row.getDefaultInstance() : row_;
                } else {
                    return rowBuilder_.getMessage();
                }
            }
            /** <code>required .slave.binlog.Row row = 2;</code> */
            public Builder setRow(Row value) {
                if (rowBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    row_ = value;
                    onChanged();
                } else {
                    rowBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }
            /** <code>required .slave.binlog.Row row = 2;</code> */
            public Builder setRow(Row.Builder builderForValue) {
                if (rowBuilder_ == null) {
                    row_ = builderForValue.build();
                    onChanged();
                } else {
                    rowBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000002;
                return this;
            }
            /** <code>required .slave.binlog.Row row = 2;</code> */
            public Builder mergeRow(Row value) {
                if (rowBuilder_ == null) {
                    if (((bitField0_ & 0x00000002) == 0x00000002)
                            && row_ != null
                            && row_ != Row.getDefaultInstance()) {
                        row_ = Row.newBuilder(row_).mergeFrom(value).buildPartial();
                    } else {
                        row_ = value;
                    }
                    onChanged();
                } else {
                    rowBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }
            /** <code>required .slave.binlog.Row row = 2;</code> */
            public Builder clearRow() {
                if (rowBuilder_ == null) {
                    row_ = null;
                    onChanged();
                } else {
                    rowBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }
            /** <code>required .slave.binlog.Row row = 2;</code> */
            public Row.Builder getRowBuilder() {
                bitField0_ |= 0x00000002;
                onChanged();
                return getRowFieldBuilder().getBuilder();
            }
            /** <code>required .slave.binlog.Row row = 2;</code> */
            public RowOrBuilder getRowOrBuilder() {
                if (rowBuilder_ != null) {
                    return rowBuilder_.getMessageOrBuilder();
                } else {
                    return row_ == null ? Row.getDefaultInstance() : row_;
                }
            }
            /** <code>required .slave.binlog.Row row = 2;</code> */
            private com.google.protobuf.SingleFieldBuilderV3<Row, Row.Builder, RowOrBuilder>
                    getRowFieldBuilder() {
                if (rowBuilder_ == null) {
                    rowBuilder_ =
                            new com.google.protobuf.SingleFieldBuilderV3<
                                    Row, Row.Builder, RowOrBuilder>(
                                    getRow(), getParentForChildren(), isClean());
                    row_ = null;
                }
                return rowBuilder_;
            }

            private Row changeRow_;
            private com.google.protobuf.SingleFieldBuilderV3<Row, Row.Builder, RowOrBuilder>
                    changeRowBuilder_;
            /**
             *
             *
             * <pre>
             * for Update MutationType only
             * </pre>
             *
             * <code>optional .slave.binlog.Row change_row = 3;</code>
             */
            public boolean hasChangeRow() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }
            /**
             *
             *
             * <pre>
             * for Update MutationType only
             * </pre>
             *
             * <code>optional .slave.binlog.Row change_row = 3;</code>
             */
            public Row getChangeRow() {
                if (changeRowBuilder_ == null) {
                    return changeRow_ == null ? Row.getDefaultInstance() : changeRow_;
                } else {
                    return changeRowBuilder_.getMessage();
                }
            }
            /**
             *
             *
             * <pre>
             * for Update MutationType only
             * </pre>
             *
             * <code>optional .slave.binlog.Row change_row = 3;</code>
             */
            public Builder setChangeRow(Row value) {
                if (changeRowBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    changeRow_ = value;
                    onChanged();
                } else {
                    changeRowBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000004;
                return this;
            }
            /**
             *
             *
             * <pre>
             * for Update MutationType only
             * </pre>
             *
             * <code>optional .slave.binlog.Row change_row = 3;</code>
             */
            public Builder setChangeRow(Row.Builder builderForValue) {
                if (changeRowBuilder_ == null) {
                    changeRow_ = builderForValue.build();
                    onChanged();
                } else {
                    changeRowBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000004;
                return this;
            }
            /**
             *
             *
             * <pre>
             * for Update MutationType only
             * </pre>
             *
             * <code>optional .slave.binlog.Row change_row = 3;</code>
             */
            public Builder mergeChangeRow(Row value) {
                if (changeRowBuilder_ == null) {
                    if (((bitField0_ & 0x00000004) == 0x00000004)
                            && changeRow_ != null
                            && changeRow_ != Row.getDefaultInstance()) {
                        changeRow_ = Row.newBuilder(changeRow_).mergeFrom(value).buildPartial();
                    } else {
                        changeRow_ = value;
                    }
                    onChanged();
                } else {
                    changeRowBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000004;
                return this;
            }
            /**
             *
             *
             * <pre>
             * for Update MutationType only
             * </pre>
             *
             * <code>optional .slave.binlog.Row change_row = 3;</code>
             */
            public Builder clearChangeRow() {
                if (changeRowBuilder_ == null) {
                    changeRow_ = null;
                    onChanged();
                } else {
                    changeRowBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }
            /**
             *
             *
             * <pre>
             * for Update MutationType only
             * </pre>
             *
             * <code>optional .slave.binlog.Row change_row = 3;</code>
             */
            public Row.Builder getChangeRowBuilder() {
                bitField0_ |= 0x00000004;
                onChanged();
                return getChangeRowFieldBuilder().getBuilder();
            }
            /**
             *
             *
             * <pre>
             * for Update MutationType only
             * </pre>
             *
             * <code>optional .slave.binlog.Row change_row = 3;</code>
             */
            public RowOrBuilder getChangeRowOrBuilder() {
                if (changeRowBuilder_ != null) {
                    return changeRowBuilder_.getMessageOrBuilder();
                } else {
                    return changeRow_ == null ? Row.getDefaultInstance() : changeRow_;
                }
            }
            /**
             *
             *
             * <pre>
             * for Update MutationType only
             * </pre>
             *
             * <code>optional .slave.binlog.Row change_row = 3;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<Row, Row.Builder, RowOrBuilder>
                    getChangeRowFieldBuilder() {
                if (changeRowBuilder_ == null) {
                    changeRowBuilder_ =
                            new com.google.protobuf.SingleFieldBuilderV3<
                                    Row, Row.Builder, RowOrBuilder>(
                                    getChangeRow(), getParentForChildren(), isClean());
                    changeRow_ = null;
                }
                return changeRowBuilder_;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:slave.binlog.TableMutation)
        }

        // @@protoc_insertion_point(class_scope:slave.binlog.TableMutation)
        private static final TableMutation DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new TableMutation();
        }

        public static TableMutation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<TableMutation> PARSER =
                new com.google.protobuf.AbstractParser<TableMutation>() {
                    @Override
                    public TableMutation parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new TableMutation(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<TableMutation> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<TableMutation> getParserForType() {
            return PARSER;
        }

        @Override
        public TableMutation getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface DMLDataOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:slave.binlog.DMLData)
            com.google.protobuf.MessageOrBuilder {

        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        java.util.List<Table> getTablesList();
        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        Table getTables(int index);
        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        int getTablesCount();
        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        java.util.List<? extends TableOrBuilder> getTablesOrBuilderList();
        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        TableOrBuilder getTablesOrBuilder(int index);
    }
    /** Protobuf type {@code slave.binlog.DMLData} */
    public static final class DMLData extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:slave.binlog.DMLData)
            DMLDataOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use DMLData.newBuilder() to construct.
        private DMLData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private DMLData() {
            tables_ = java.util.Collections.emptyList();
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DMLData(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            {
                                if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                                    tables_ = new java.util.ArrayList<Table>();
                                    mutable_bitField0_ |= 0x00000001;
                                }
                                tables_.add(input.readMessage(Table.PARSER, extensionRegistry));
                                break;
                            }
                        default:
                            {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                    tables_ = java.util.Collections.unmodifiableList(tables_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return BinLog.internal_static_slave_binlog_DMLData_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return BinLog.internal_static_slave_binlog_DMLData_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(DMLData.class, Builder.class);
        }

        public static final int TABLES_FIELD_NUMBER = 1;
        private java.util.List<Table> tables_;
        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        public java.util.List<Table> getTablesList() {
            return tables_;
        }
        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        public java.util.List<? extends TableOrBuilder> getTablesOrBuilderList() {
            return tables_;
        }
        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        public int getTablesCount() {
            return tables_.size();
        }
        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        public Table getTables(int index) {
            return tables_.get(index);
        }
        /**
         *
         *
         * <pre>
         * tables contains all the table changes.
         * </pre>
         *
         * <code>repeated .slave.binlog.Table tables = 1;</code>
         */
        public TableOrBuilder getTablesOrBuilder(int index) {
            return tables_.get(index);
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            for (int i = 0; i < getTablesCount(); i++) {
                if (!getTables(i).isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            for (int i = 0; i < tables_.size(); i++) {
                output.writeMessage(1, tables_.get(i));
            }
            unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            for (int i = 0; i < tables_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, tables_.get(i));
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DMLData)) {
                return super.equals(obj);
            }
            DMLData other = (DMLData) obj;

            boolean result = true;
            result = result && getTablesList().equals(other.getTablesList());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (getTablesCount() > 0) {
                hash = (37 * hash) + TABLES_FIELD_NUMBER;
                hash = (53 * hash) + getTablesList().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static DMLData parseFrom(java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DMLData parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DMLData parseFrom(com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DMLData parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DMLData parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DMLData parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DMLData parseFrom(java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DMLData parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static DMLData parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input);
        }

        public static DMLData parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static DMLData parseFrom(com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DMLData parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DMLData prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /** Protobuf type {@code slave.binlog.DMLData} */
        public static final class Builder
                extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:slave.binlog.DMLData)
                DMLDataOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return BinLog.internal_static_slave_binlog_DMLData_descriptor;
            }

            @Override
            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return BinLog.internal_static_slave_binlog_DMLData_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(DMLData.class, Builder.class);
            }

            // Construct using com.fcbox.move.bean.BinLog.DMLData.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getTablesFieldBuilder();
                }
            }

            @Override
            public Builder clear() {
                super.clear();
                if (tablesBuilder_ == null) {
                    tables_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                } else {
                    tablesBuilder_.clear();
                }
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return BinLog.internal_static_slave_binlog_DMLData_descriptor;
            }

            @Override
            public DMLData getDefaultInstanceForType() {
                return DMLData.getDefaultInstance();
            }

            @Override
            public DMLData build() {
                DMLData result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public DMLData buildPartial() {
                DMLData result = new DMLData(this);
                int from_bitField0_ = bitField0_;
                if (tablesBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) == 0x00000001)) {
                        tables_ = java.util.Collections.unmodifiableList(tables_);
                        bitField0_ = (bitField0_ & ~0x00000001);
                    }
                    result.tables_ = tables_;
                } else {
                    result.tables_ = tablesBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override
            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override
            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index,
                    Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof DMLData) {
                    return mergeFrom((DMLData) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(DMLData other) {
                if (other == DMLData.getDefaultInstance()) return this;
                if (tablesBuilder_ == null) {
                    if (!other.tables_.isEmpty()) {
                        if (tables_.isEmpty()) {
                            tables_ = other.tables_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                        } else {
                            ensureTablesIsMutable();
                            tables_.addAll(other.tables_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.tables_.isEmpty()) {
                        if (tablesBuilder_.isEmpty()) {
                            tablesBuilder_.dispose();
                            tablesBuilder_ = null;
                            tables_ = other.tables_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                            tablesBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                                            ? getTablesFieldBuilder()
                                            : null;
                        } else {
                            tablesBuilder_.addAllMessages(other.tables_);
                        }
                    }
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i = 0; i < getTablesCount(); i++) {
                    if (!getTables(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                DMLData parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (DMLData) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.util.List<Table> tables_ = java.util.Collections.emptyList();

            private void ensureTablesIsMutable() {
                if (!((bitField0_ & 0x00000001) == 0x00000001)) {
                    tables_ = new java.util.ArrayList<Table>(tables_);
                    bitField0_ |= 0x00000001;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<Table, Table.Builder, TableOrBuilder>
                    tablesBuilder_;

            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public java.util.List<Table> getTablesList() {
                if (tablesBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(tables_);
                } else {
                    return tablesBuilder_.getMessageList();
                }
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public int getTablesCount() {
                if (tablesBuilder_ == null) {
                    return tables_.size();
                } else {
                    return tablesBuilder_.getCount();
                }
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Table getTables(int index) {
                if (tablesBuilder_ == null) {
                    return tables_.get(index);
                } else {
                    return tablesBuilder_.getMessage(index);
                }
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Builder setTables(int index, Table value) {
                if (tablesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureTablesIsMutable();
                    tables_.set(index, value);
                    onChanged();
                } else {
                    tablesBuilder_.setMessage(index, value);
                }
                return this;
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Builder setTables(int index, Table.Builder builderForValue) {
                if (tablesBuilder_ == null) {
                    ensureTablesIsMutable();
                    tables_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    tablesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Builder addTables(Table value) {
                if (tablesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureTablesIsMutable();
                    tables_.add(value);
                    onChanged();
                } else {
                    tablesBuilder_.addMessage(value);
                }
                return this;
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Builder addTables(int index, Table value) {
                if (tablesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureTablesIsMutable();
                    tables_.add(index, value);
                    onChanged();
                } else {
                    tablesBuilder_.addMessage(index, value);
                }
                return this;
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Builder addTables(Table.Builder builderForValue) {
                if (tablesBuilder_ == null) {
                    ensureTablesIsMutable();
                    tables_.add(builderForValue.build());
                    onChanged();
                } else {
                    tablesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Builder addTables(int index, Table.Builder builderForValue) {
                if (tablesBuilder_ == null) {
                    ensureTablesIsMutable();
                    tables_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    tablesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Builder addAllTables(Iterable<? extends Table> values) {
                if (tablesBuilder_ == null) {
                    ensureTablesIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, tables_);
                    onChanged();
                } else {
                    tablesBuilder_.addAllMessages(values);
                }
                return this;
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Builder clearTables() {
                if (tablesBuilder_ == null) {
                    tables_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                    onChanged();
                } else {
                    tablesBuilder_.clear();
                }
                return this;
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Builder removeTables(int index) {
                if (tablesBuilder_ == null) {
                    ensureTablesIsMutable();
                    tables_.remove(index);
                    onChanged();
                } else {
                    tablesBuilder_.remove(index);
                }
                return this;
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Table.Builder getTablesBuilder(int index) {
                return getTablesFieldBuilder().getBuilder(index);
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public TableOrBuilder getTablesOrBuilder(int index) {
                if (tablesBuilder_ == null) {
                    return tables_.get(index);
                } else {
                    return tablesBuilder_.getMessageOrBuilder(index);
                }
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public java.util.List<? extends TableOrBuilder> getTablesOrBuilderList() {
                if (tablesBuilder_ != null) {
                    return tablesBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(tables_);
                }
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Table.Builder addTablesBuilder() {
                return getTablesFieldBuilder().addBuilder(Table.getDefaultInstance());
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public Table.Builder addTablesBuilder(int index) {
                return getTablesFieldBuilder().addBuilder(index, Table.getDefaultInstance());
            }
            /**
             *
             *
             * <pre>
             * tables contains all the table changes.
             * </pre>
             *
             * <code>repeated .slave.binlog.Table tables = 1;</code>
             */
            public java.util.List<Table.Builder> getTablesBuilderList() {
                return getTablesFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<Table, Table.Builder, TableOrBuilder>
                    getTablesFieldBuilder() {
                if (tablesBuilder_ == null) {
                    tablesBuilder_ =
                            new com.google.protobuf.RepeatedFieldBuilderV3<
                                    Table, Table.Builder, TableOrBuilder>(
                                    tables_,
                                    ((bitField0_ & 0x00000001) == 0x00000001),
                                    getParentForChildren(),
                                    isClean());
                    tables_ = null;
                }
                return tablesBuilder_;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:slave.binlog.DMLData)
        }

        // @@protoc_insertion_point(class_scope:slave.binlog.DMLData)
        private static final DMLData DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new DMLData();
        }

        public static DMLData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<DMLData> PARSER =
                new com.google.protobuf.AbstractParser<DMLData>() {
                    @Override
                    public DMLData parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new DMLData(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<DMLData> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<DMLData> getParserForType() {
            return PARSER;
        }

        @Override
        public DMLData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface DDLDataOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:slave.binlog.DDLData)
            com.google.protobuf.MessageOrBuilder {

        /**
         *
         *
         * <pre>
         * the current database use
         * </pre>
         *
         * <code>optional string schema_name = 1;</code>
         */
        boolean hasSchemaName();
        /**
         *
         *
         * <pre>
         * the current database use
         * </pre>
         *
         * <code>optional string schema_name = 1;</code>
         */
        String getSchemaName();
        /**
         *
         *
         * <pre>
         * the current database use
         * </pre>
         *
         * <code>optional string schema_name = 1;</code>
         */
        com.google.protobuf.ByteString getSchemaNameBytes();

        /**
         *
         *
         * <pre>
         * the relate table
         * </pre>
         *
         * <code>optional string table_name = 2;</code>
         */
        boolean hasTableName();
        /**
         *
         *
         * <pre>
         * the relate table
         * </pre>
         *
         * <code>optional string table_name = 2;</code>
         */
        String getTableName();
        /**
         *
         *
         * <pre>
         * the relate table
         * </pre>
         *
         * <code>optional string table_name = 2;</code>
         */
        com.google.protobuf.ByteString getTableNameBytes();

        /**
         *
         *
         * <pre>
         * ddl_query is the original ddl statement query.
         * </pre>
         *
         * <code>optional bytes ddl_query = 3;</code>
         */
        boolean hasDdlQuery();
        /**
         *
         *
         * <pre>
         * ddl_query is the original ddl statement query.
         * </pre>
         *
         * <code>optional bytes ddl_query = 3;</code>
         */
        com.google.protobuf.ByteString getDdlQuery();
    }
    /** Protobuf type {@code slave.binlog.DDLData} */
    public static final class DDLData extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:slave.binlog.DDLData)
            DDLDataOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use DDLData.newBuilder() to construct.
        private DDLData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private DDLData() {
            schemaName_ = "";
            tableName_ = "";
            ddlQuery_ = com.google.protobuf.ByteString.EMPTY;
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DDLData(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000001;
                                schemaName_ = bs;
                                break;
                            }
                        case 18:
                            {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000002;
                                tableName_ = bs;
                                break;
                            }
                        case 26:
                            {
                                bitField0_ |= 0x00000004;
                                ddlQuery_ = input.readBytes();
                                break;
                            }
                        default:
                            {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return BinLog.internal_static_slave_binlog_DDLData_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return BinLog.internal_static_slave_binlog_DDLData_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(DDLData.class, Builder.class);
        }

        private int bitField0_;
        public static final int SCHEMA_NAME_FIELD_NUMBER = 1;
        private volatile Object schemaName_;
        /**
         *
         *
         * <pre>
         * the current database use
         * </pre>
         *
         * <code>optional string schema_name = 1;</code>
         */
        public boolean hasSchemaName() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         *
         *
         * <pre>
         * the current database use
         * </pre>
         *
         * <code>optional string schema_name = 1;</code>
         */
        public String getSchemaName() {
            Object ref = schemaName_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    schemaName_ = s;
                }
                return s;
            }
        }
        /**
         *
         *
         * <pre>
         * the current database use
         * </pre>
         *
         * <code>optional string schema_name = 1;</code>
         */
        public com.google.protobuf.ByteString getSchemaNameBytes() {
            Object ref = schemaName_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                schemaName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int TABLE_NAME_FIELD_NUMBER = 2;
        private volatile Object tableName_;
        /**
         *
         *
         * <pre>
         * the relate table
         * </pre>
         *
         * <code>optional string table_name = 2;</code>
         */
        public boolean hasTableName() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         *
         *
         * <pre>
         * the relate table
         * </pre>
         *
         * <code>optional string table_name = 2;</code>
         */
        public String getTableName() {
            Object ref = tableName_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    tableName_ = s;
                }
                return s;
            }
        }
        /**
         *
         *
         * <pre>
         * the relate table
         * </pre>
         *
         * <code>optional string table_name = 2;</code>
         */
        public com.google.protobuf.ByteString getTableNameBytes() {
            Object ref = tableName_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                tableName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int DDL_QUERY_FIELD_NUMBER = 3;
        private com.google.protobuf.ByteString ddlQuery_;
        /**
         *
         *
         * <pre>
         * ddl_query is the original ddl statement query.
         * </pre>
         *
         * <code>optional bytes ddl_query = 3;</code>
         */
        public boolean hasDdlQuery() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }
        /**
         *
         *
         * <pre>
         * ddl_query is the original ddl statement query.
         * </pre>
         *
         * <code>optional bytes ddl_query = 3;</code>
         */
        public com.google.protobuf.ByteString getDdlQuery() {
            return ddlQuery_;
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, schemaName_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, tableName_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeBytes(3, ddlQuery_);
            }
            unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, schemaName_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, tableName_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream.computeBytesSize(3, ddlQuery_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DDLData)) {
                return super.equals(obj);
            }
            DDLData other = (DDLData) obj;

            boolean result = true;
            result = result && (hasSchemaName() == other.hasSchemaName());
            if (hasSchemaName()) {
                result = result && getSchemaName().equals(other.getSchemaName());
            }
            result = result && (hasTableName() == other.hasTableName());
            if (hasTableName()) {
                result = result && getTableName().equals(other.getTableName());
            }
            result = result && (hasDdlQuery() == other.hasDdlQuery());
            if (hasDdlQuery()) {
                result = result && getDdlQuery().equals(other.getDdlQuery());
            }
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasSchemaName()) {
                hash = (37 * hash) + SCHEMA_NAME_FIELD_NUMBER;
                hash = (53 * hash) + getSchemaName().hashCode();
            }
            if (hasTableName()) {
                hash = (37 * hash) + TABLE_NAME_FIELD_NUMBER;
                hash = (53 * hash) + getTableName().hashCode();
            }
            if (hasDdlQuery()) {
                hash = (37 * hash) + DDL_QUERY_FIELD_NUMBER;
                hash = (53 * hash) + getDdlQuery().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static DDLData parseFrom(java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DDLData parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DDLData parseFrom(com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DDLData parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DDLData parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DDLData parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DDLData parseFrom(java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DDLData parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static DDLData parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input);
        }

        public static DDLData parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static DDLData parseFrom(com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DDLData parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DDLData prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /** Protobuf type {@code slave.binlog.DDLData} */
        public static final class Builder
                extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:slave.binlog.DDLData)
                DDLDataOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return BinLog.internal_static_slave_binlog_DDLData_descriptor;
            }

            @Override
            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return BinLog.internal_static_slave_binlog_DDLData_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(DDLData.class, Builder.class);
            }

            // Construct using com.fcbox.move.bean.BinLog.DDLData.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
            }

            @Override
            public Builder clear() {
                super.clear();
                schemaName_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                tableName_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                ddlQuery_ = com.google.protobuf.ByteString.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return BinLog.internal_static_slave_binlog_DDLData_descriptor;
            }

            @Override
            public DDLData getDefaultInstanceForType() {
                return DDLData.getDefaultInstance();
            }

            @Override
            public DDLData build() {
                DDLData result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public DDLData buildPartial() {
                DDLData result = new DDLData(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.schemaName_ = schemaName_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.tableName_ = tableName_;
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.ddlQuery_ = ddlQuery_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override
            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override
            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index,
                    Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof DDLData) {
                    return mergeFrom((DDLData) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(DDLData other) {
                if (other == DDLData.getDefaultInstance()) return this;
                if (other.hasSchemaName()) {
                    bitField0_ |= 0x00000001;
                    schemaName_ = other.schemaName_;
                    onChanged();
                }
                if (other.hasTableName()) {
                    bitField0_ |= 0x00000002;
                    tableName_ = other.tableName_;
                    onChanged();
                }
                if (other.hasDdlQuery()) {
                    setDdlQuery(other.getDdlQuery());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                DDLData parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (DDLData) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private Object schemaName_ = "";
            /**
             *
             *
             * <pre>
             * the current database use
             * </pre>
             *
             * <code>optional string schema_name = 1;</code>
             */
            public boolean hasSchemaName() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /**
             *
             *
             * <pre>
             * the current database use
             * </pre>
             *
             * <code>optional string schema_name = 1;</code>
             */
            public String getSchemaName() {
                Object ref = schemaName_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        schemaName_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             *
             *
             * <pre>
             * the current database use
             * </pre>
             *
             * <code>optional string schema_name = 1;</code>
             */
            public com.google.protobuf.ByteString getSchemaNameBytes() {
                Object ref = schemaName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                    schemaName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             *
             *
             * <pre>
             * the current database use
             * </pre>
             *
             * <code>optional string schema_name = 1;</code>
             */
            public Builder setSchemaName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                schemaName_ = value;
                onChanged();
                return this;
            }
            /**
             *
             *
             * <pre>
             * the current database use
             * </pre>
             *
             * <code>optional string schema_name = 1;</code>
             */
            public Builder clearSchemaName() {
                bitField0_ = (bitField0_ & ~0x00000001);
                schemaName_ = getDefaultInstance().getSchemaName();
                onChanged();
                return this;
            }
            /**
             *
             *
             * <pre>
             * the current database use
             * </pre>
             *
             * <code>optional string schema_name = 1;</code>
             */
            public Builder setSchemaNameBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                schemaName_ = value;
                onChanged();
                return this;
            }

            private Object tableName_ = "";
            /**
             *
             *
             * <pre>
             * the relate table
             * </pre>
             *
             * <code>optional string table_name = 2;</code>
             */
            public boolean hasTableName() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             *
             *
             * <pre>
             * the relate table
             * </pre>
             *
             * <code>optional string table_name = 2;</code>
             */
            public String getTableName() {
                Object ref = tableName_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        tableName_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             *
             *
             * <pre>
             * the relate table
             * </pre>
             *
             * <code>optional string table_name = 2;</code>
             */
            public com.google.protobuf.ByteString getTableNameBytes() {
                Object ref = tableName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                    tableName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             *
             *
             * <pre>
             * the relate table
             * </pre>
             *
             * <code>optional string table_name = 2;</code>
             */
            public Builder setTableName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                tableName_ = value;
                onChanged();
                return this;
            }
            /**
             *
             *
             * <pre>
             * the relate table
             * </pre>
             *
             * <code>optional string table_name = 2;</code>
             */
            public Builder clearTableName() {
                bitField0_ = (bitField0_ & ~0x00000002);
                tableName_ = getDefaultInstance().getTableName();
                onChanged();
                return this;
            }
            /**
             *
             *
             * <pre>
             * the relate table
             * </pre>
             *
             * <code>optional string table_name = 2;</code>
             */
            public Builder setTableNameBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                tableName_ = value;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString ddlQuery_ = com.google.protobuf.ByteString.EMPTY;
            /**
             *
             *
             * <pre>
             * ddl_query is the original ddl statement query.
             * </pre>
             *
             * <code>optional bytes ddl_query = 3;</code>
             */
            public boolean hasDdlQuery() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }
            /**
             *
             *
             * <pre>
             * ddl_query is the original ddl statement query.
             * </pre>
             *
             * <code>optional bytes ddl_query = 3;</code>
             */
            public com.google.protobuf.ByteString getDdlQuery() {
                return ddlQuery_;
            }
            /**
             *
             *
             * <pre>
             * ddl_query is the original ddl statement query.
             * </pre>
             *
             * <code>optional bytes ddl_query = 3;</code>
             */
            public Builder setDdlQuery(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                ddlQuery_ = value;
                onChanged();
                return this;
            }
            /**
             *
             *
             * <pre>
             * ddl_query is the original ddl statement query.
             * </pre>
             *
             * <code>optional bytes ddl_query = 3;</code>
             */
            public Builder clearDdlQuery() {
                bitField0_ = (bitField0_ & ~0x00000004);
                ddlQuery_ = getDefaultInstance().getDdlQuery();
                onChanged();
                return this;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:slave.binlog.DDLData)
        }

        // @@protoc_insertion_point(class_scope:slave.binlog.DDLData)
        private static final DDLData DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new DDLData();
        }

        public static DDLData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<DDLData> PARSER =
                new com.google.protobuf.AbstractParser<DDLData>() {
                    @Override
                    public DDLData parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new DDLData(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<DDLData> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<DDLData> getParserForType() {
            return PARSER;
        }

        @Override
        public DDLData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface BinlogOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:slave.binlog.Binlog)
            com.google.protobuf.MessageOrBuilder {

        /** <code>optional .slave.binlog.BinlogType type = 1;</code> */
        boolean hasType();
        /** <code>optional .slave.binlog.BinlogType type = 1;</code> */
        BinlogType getType();

        /** <code>optional int64 commit_ts = 2;</code> */
        boolean hasCommitTs();
        /** <code>optional int64 commit_ts = 2;</code> */
        long getCommitTs();

        /**
         *
         *
         * <pre>
         * dml_data is marshalled from DML type
         * </pre>
         *
         * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
         */
        boolean hasDmlData();
        /**
         *
         *
         * <pre>
         * dml_data is marshalled from DML type
         * </pre>
         *
         * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
         */
        DMLData getDmlData();
        /**
         *
         *
         * <pre>
         * dml_data is marshalled from DML type
         * </pre>
         *
         * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
         */
        DMLDataOrBuilder getDmlDataOrBuilder();

        /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
        boolean hasDdlData();
        /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
        DDLData getDdlData();
        /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
        DDLDataOrBuilder getDdlDataOrBuilder();
    }
    /**
     *
     *
     * <pre>
     * Binlog contains all the changes in a transaction.
     * </pre>
     *
     * Protobuf type {@code slave.binlog.Binlog}
     */
    public static final class Binlog extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:slave.binlog.Binlog)
            BinlogOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use Binlog.newBuilder() to construct.
        private Binlog(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private Binlog() {
            type_ = 0;
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Binlog(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            {
                                int rawValue = input.readEnum();
                                @SuppressWarnings("deprecation")
                                BinlogType value = BinlogType.valueOf(rawValue);
                                if (value == null) {
                                    unknownFields.mergeVarintField(1, rawValue);
                                } else {
                                    bitField0_ |= 0x00000001;
                                    type_ = rawValue;
                                }
                                break;
                            }
                        case 16:
                            {
                                bitField0_ |= 0x00000002;
                                commitTs_ = input.readInt64();
                                break;
                            }
                        case 26:
                            {
                                DMLData.Builder subBuilder = null;
                                if (((bitField0_ & 0x00000004) == 0x00000004)) {
                                    subBuilder = dmlData_.toBuilder();
                                }
                                dmlData_ = input.readMessage(DMLData.PARSER, extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(dmlData_);
                                    dmlData_ = subBuilder.buildPartial();
                                }
                                bitField0_ |= 0x00000004;
                                break;
                            }
                        case 34:
                            {
                                DDLData.Builder subBuilder = null;
                                if (((bitField0_ & 0x00000008) == 0x00000008)) {
                                    subBuilder = ddlData_.toBuilder();
                                }
                                ddlData_ = input.readMessage(DDLData.PARSER, extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(ddlData_);
                                    ddlData_ = subBuilder.buildPartial();
                                }
                                bitField0_ |= 0x00000008;
                                break;
                            }
                        default:
                            {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e)
                        .setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return BinLog.internal_static_slave_binlog_Binlog_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return BinLog.internal_static_slave_binlog_Binlog_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(Binlog.class, Builder.class);
        }

        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        /** <code>optional .slave.binlog.BinlogType type = 1;</code> */
        public boolean hasType() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /** <code>optional .slave.binlog.BinlogType type = 1;</code> */
        public BinlogType getType() {
            @SuppressWarnings("deprecation")
            BinlogType result = BinlogType.valueOf(type_);
            return result == null ? BinlogType.DML : result;
        }

        public static final int COMMIT_TS_FIELD_NUMBER = 2;
        private long commitTs_;
        /** <code>optional int64 commit_ts = 2;</code> */
        public boolean hasCommitTs() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /** <code>optional int64 commit_ts = 2;</code> */
        public long getCommitTs() {
            return commitTs_;
        }

        public static final int DML_DATA_FIELD_NUMBER = 3;
        private DMLData dmlData_;
        /**
         *
         *
         * <pre>
         * dml_data is marshalled from DML type
         * </pre>
         *
         * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
         */
        public boolean hasDmlData() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }
        /**
         *
         *
         * <pre>
         * dml_data is marshalled from DML type
         * </pre>
         *
         * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
         */
        public DMLData getDmlData() {
            return dmlData_ == null ? DMLData.getDefaultInstance() : dmlData_;
        }
        /**
         *
         *
         * <pre>
         * dml_data is marshalled from DML type
         * </pre>
         *
         * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
         */
        public DMLDataOrBuilder getDmlDataOrBuilder() {
            return dmlData_ == null ? DMLData.getDefaultInstance() : dmlData_;
        }

        public static final int DDL_DATA_FIELD_NUMBER = 4;
        private DDLData ddlData_;
        /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
        public boolean hasDdlData() {
            return ((bitField0_ & 0x00000008) == 0x00000008);
        }
        /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
        public DDLData getDdlData() {
            return ddlData_ == null ? DDLData.getDefaultInstance() : ddlData_;
        }
        /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
        public DDLDataOrBuilder getDdlDataOrBuilder() {
            return ddlData_ == null ? DDLData.getDefaultInstance() : ddlData_;
        }

        private byte memoizedIsInitialized = -1;

        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (hasDmlData()) {
                if (!getDmlData().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeEnum(1, type_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeInt64(2, commitTs_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeMessage(3, getDmlData());
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                output.writeMessage(4, getDdlData());
            }
            unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream.computeEnumSize(1, type_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, commitTs_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, getDmlData());
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(4, getDdlData());
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Binlog)) {
                return super.equals(obj);
            }
            Binlog other = (Binlog) obj;

            boolean result = true;
            result = result && (hasType() == other.hasType());
            if (hasType()) {
                result = result && type_ == other.type_;
            }
            result = result && (hasCommitTs() == other.hasCommitTs());
            if (hasCommitTs()) {
                result = result && (getCommitTs() == other.getCommitTs());
            }
            result = result && (hasDmlData() == other.hasDmlData());
            if (hasDmlData()) {
                result = result && getDmlData().equals(other.getDmlData());
            }
            result = result && (hasDdlData() == other.hasDdlData());
            if (hasDdlData()) {
                result = result && getDdlData().equals(other.getDdlData());
            }
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasType()) {
                hash = (37 * hash) + TYPE_FIELD_NUMBER;
                hash = (53 * hash) + type_;
            }
            if (hasCommitTs()) {
                hash = (37 * hash) + COMMIT_TS_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCommitTs());
            }
            if (hasDmlData()) {
                hash = (37 * hash) + DML_DATA_FIELD_NUMBER;
                hash = (53 * hash) + getDmlData().hashCode();
            }
            if (hasDdlData()) {
                hash = (37 * hash) + DDL_DATA_FIELD_NUMBER;
                hash = (53 * hash) + getDdlData().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static Binlog parseFrom(java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Binlog parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Binlog parseFrom(com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Binlog parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Binlog parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Binlog parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Binlog parseFrom(java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Binlog parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static Binlog parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input);
        }

        public static Binlog parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static Binlog parseFrom(com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Binlog parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                    PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Binlog prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         *
         *
         * <pre>
         * Binlog contains all the changes in a transaction.
         * </pre>
         *
         * Protobuf type {@code slave.binlog.Binlog}
         */
        public static final class Builder
                extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:slave.binlog.Binlog)
                BinlogOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return BinLog.internal_static_slave_binlog_Binlog_descriptor;
            }

            @Override
            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return BinLog.internal_static_slave_binlog_Binlog_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(Binlog.class, Builder.class);
            }

            // Construct using com.fcbox.move.bean.BinLog.Binlog.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getDmlDataFieldBuilder();
                    getDdlDataFieldBuilder();
                }
            }

            @Override
            public Builder clear() {
                super.clear();
                type_ = 0;
                bitField0_ = (bitField0_ & ~0x00000001);
                commitTs_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000002);
                if (dmlDataBuilder_ == null) {
                    dmlData_ = null;
                } else {
                    dmlDataBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000004);
                if (ddlDataBuilder_ == null) {
                    ddlData_ = null;
                } else {
                    ddlDataBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000008);
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return BinLog.internal_static_slave_binlog_Binlog_descriptor;
            }

            @Override
            public Binlog getDefaultInstanceForType() {
                return Binlog.getDefaultInstance();
            }

            @Override
            public Binlog build() {
                Binlog result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public Binlog buildPartial() {
                Binlog result = new Binlog(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.type_ = type_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    result.commitTs_ = commitTs_;
                    to_bitField0_ |= 0x00000002;
                }
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    if (dmlDataBuilder_ == null) {
                        result.dmlData_ = dmlData_;
                    } else {
                        result.dmlData_ = dmlDataBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000004;
                }
                if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
                    if (ddlDataBuilder_ == null) {
                        result.ddlData_ = ddlData_;
                    } else {
                        result.ddlData_ = ddlDataBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000008;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override
            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override
            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index,
                    Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Binlog) {
                    return mergeFrom((Binlog) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(Binlog other) {
                if (other == Binlog.getDefaultInstance()) return this;
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasCommitTs()) {
                    setCommitTs(other.getCommitTs());
                }
                if (other.hasDmlData()) {
                    mergeDmlData(other.getDmlData());
                }
                if (other.hasDdlData()) {
                    mergeDdlData(other.getDdlData());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (hasDmlData()) {
                    if (!getDmlData().isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                Binlog parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (Binlog) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private int type_ = 0;
            /** <code>optional .slave.binlog.BinlogType type = 1;</code> */
            public boolean hasType() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /** <code>optional .slave.binlog.BinlogType type = 1;</code> */
            public BinlogType getType() {
                @SuppressWarnings("deprecation")
                BinlogType result = BinlogType.valueOf(type_);
                return result == null ? BinlogType.DML : result;
            }
            /** <code>optional .slave.binlog.BinlogType type = 1;</code> */
            public Builder setType(BinlogType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                type_ = value.getNumber();
                onChanged();
                return this;
            }
            /** <code>optional .slave.binlog.BinlogType type = 1;</code> */
            public Builder clearType() {
                bitField0_ = (bitField0_ & ~0x00000001);
                type_ = 0;
                onChanged();
                return this;
            }

            private long commitTs_;
            /** <code>optional int64 commit_ts = 2;</code> */
            public boolean hasCommitTs() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /** <code>optional int64 commit_ts = 2;</code> */
            public long getCommitTs() {
                return commitTs_;
            }
            /** <code>optional int64 commit_ts = 2;</code> */
            public Builder setCommitTs(long value) {
                bitField0_ |= 0x00000002;
                commitTs_ = value;
                onChanged();
                return this;
            }
            /** <code>optional int64 commit_ts = 2;</code> */
            public Builder clearCommitTs() {
                bitField0_ = (bitField0_ & ~0x00000002);
                commitTs_ = 0L;
                onChanged();
                return this;
            }

            private DMLData dmlData_;
            private com.google.protobuf.SingleFieldBuilderV3<
                            DMLData, DMLData.Builder, DMLDataOrBuilder>
                    dmlDataBuilder_;
            /**
             *
             *
             * <pre>
             * dml_data is marshalled from DML type
             * </pre>
             *
             * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
             */
            public boolean hasDmlData() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }
            /**
             *
             *
             * <pre>
             * dml_data is marshalled from DML type
             * </pre>
             *
             * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
             */
            public DMLData getDmlData() {
                if (dmlDataBuilder_ == null) {
                    return dmlData_ == null ? DMLData.getDefaultInstance() : dmlData_;
                } else {
                    return dmlDataBuilder_.getMessage();
                }
            }
            /**
             *
             *
             * <pre>
             * dml_data is marshalled from DML type
             * </pre>
             *
             * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
             */
            public Builder setDmlData(DMLData value) {
                if (dmlDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    dmlData_ = value;
                    onChanged();
                } else {
                    dmlDataBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000004;
                return this;
            }
            /**
             *
             *
             * <pre>
             * dml_data is marshalled from DML type
             * </pre>
             *
             * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
             */
            public Builder setDmlData(DMLData.Builder builderForValue) {
                if (dmlDataBuilder_ == null) {
                    dmlData_ = builderForValue.build();
                    onChanged();
                } else {
                    dmlDataBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000004;
                return this;
            }
            /**
             *
             *
             * <pre>
             * dml_data is marshalled from DML type
             * </pre>
             *
             * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
             */
            public Builder mergeDmlData(DMLData value) {
                if (dmlDataBuilder_ == null) {
                    if (((bitField0_ & 0x00000004) == 0x00000004)
                            && dmlData_ != null
                            && dmlData_ != DMLData.getDefaultInstance()) {
                        dmlData_ = DMLData.newBuilder(dmlData_).mergeFrom(value).buildPartial();
                    } else {
                        dmlData_ = value;
                    }
                    onChanged();
                } else {
                    dmlDataBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000004;
                return this;
            }
            /**
             *
             *
             * <pre>
             * dml_data is marshalled from DML type
             * </pre>
             *
             * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
             */
            public Builder clearDmlData() {
                if (dmlDataBuilder_ == null) {
                    dmlData_ = null;
                    onChanged();
                } else {
                    dmlDataBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }
            /**
             *
             *
             * <pre>
             * dml_data is marshalled from DML type
             * </pre>
             *
             * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
             */
            public DMLData.Builder getDmlDataBuilder() {
                bitField0_ |= 0x00000004;
                onChanged();
                return getDmlDataFieldBuilder().getBuilder();
            }
            /**
             *
             *
             * <pre>
             * dml_data is marshalled from DML type
             * </pre>
             *
             * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
             */
            public DMLDataOrBuilder getDmlDataOrBuilder() {
                if (dmlDataBuilder_ != null) {
                    return dmlDataBuilder_.getMessageOrBuilder();
                } else {
                    return dmlData_ == null ? DMLData.getDefaultInstance() : dmlData_;
                }
            }
            /**
             *
             *
             * <pre>
             * dml_data is marshalled from DML type
             * </pre>
             *
             * <code>optional .slave.binlog.DMLData dml_data = 3;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                            DMLData, DMLData.Builder, DMLDataOrBuilder>
                    getDmlDataFieldBuilder() {
                if (dmlDataBuilder_ == null) {
                    dmlDataBuilder_ =
                            new com.google.protobuf.SingleFieldBuilderV3<
                                    DMLData, DMLData.Builder, DMLDataOrBuilder>(
                                    getDmlData(), getParentForChildren(), isClean());
                    dmlData_ = null;
                }
                return dmlDataBuilder_;
            }

            private DDLData ddlData_;
            private com.google.protobuf.SingleFieldBuilderV3<
                            DDLData, DDLData.Builder, DDLDataOrBuilder>
                    ddlDataBuilder_;
            /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
            public boolean hasDdlData() {
                return ((bitField0_ & 0x00000008) == 0x00000008);
            }
            /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
            public DDLData getDdlData() {
                if (ddlDataBuilder_ == null) {
                    return ddlData_ == null ? DDLData.getDefaultInstance() : ddlData_;
                } else {
                    return ddlDataBuilder_.getMessage();
                }
            }
            /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
            public Builder setDdlData(DDLData value) {
                if (ddlDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ddlData_ = value;
                    onChanged();
                } else {
                    ddlDataBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000008;
                return this;
            }
            /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
            public Builder setDdlData(DDLData.Builder builderForValue) {
                if (ddlDataBuilder_ == null) {
                    ddlData_ = builderForValue.build();
                    onChanged();
                } else {
                    ddlDataBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000008;
                return this;
            }
            /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
            public Builder mergeDdlData(DDLData value) {
                if (ddlDataBuilder_ == null) {
                    if (((bitField0_ & 0x00000008) == 0x00000008)
                            && ddlData_ != null
                            && ddlData_ != DDLData.getDefaultInstance()) {
                        ddlData_ = DDLData.newBuilder(ddlData_).mergeFrom(value).buildPartial();
                    } else {
                        ddlData_ = value;
                    }
                    onChanged();
                } else {
                    ddlDataBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000008;
                return this;
            }
            /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
            public Builder clearDdlData() {
                if (ddlDataBuilder_ == null) {
                    ddlData_ = null;
                    onChanged();
                } else {
                    ddlDataBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000008);
                return this;
            }
            /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
            public DDLData.Builder getDdlDataBuilder() {
                bitField0_ |= 0x00000008;
                onChanged();
                return getDdlDataFieldBuilder().getBuilder();
            }
            /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
            public DDLDataOrBuilder getDdlDataOrBuilder() {
                if (ddlDataBuilder_ != null) {
                    return ddlDataBuilder_.getMessageOrBuilder();
                } else {
                    return ddlData_ == null ? DDLData.getDefaultInstance() : ddlData_;
                }
            }
            /** <code>optional .slave.binlog.DDLData ddl_data = 4;</code> */
            private com.google.protobuf.SingleFieldBuilderV3<
                            DDLData, DDLData.Builder, DDLDataOrBuilder>
                    getDdlDataFieldBuilder() {
                if (ddlDataBuilder_ == null) {
                    ddlDataBuilder_ =
                            new com.google.protobuf.SingleFieldBuilderV3<
                                    DDLData, DDLData.Builder, DDLDataOrBuilder>(
                                    getDdlData(), getParentForChildren(), isClean());
                    ddlData_ = null;
                }
                return ddlDataBuilder_;
            }

            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:slave.binlog.Binlog)
        }

        // @@protoc_insertion_point(class_scope:slave.binlog.Binlog)
        private static final Binlog DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new Binlog();
        }

        public static Binlog getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<Binlog> PARSER =
                new com.google.protobuf.AbstractParser<Binlog>() {
                    @Override
                    public Binlog parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new Binlog(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<Binlog> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<Binlog> getParserForType() {
            return PARSER;
        }

        @Override
        public Binlog getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_slave_binlog_Column_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_slave_binlog_Column_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_slave_binlog_ColumnInfo_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_slave_binlog_ColumnInfo_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_slave_binlog_Row_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_slave_binlog_Row_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_slave_binlog_Table_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_slave_binlog_Table_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_slave_binlog_TableMutation_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_slave_binlog_TableMutation_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_slave_binlog_DMLData_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_slave_binlog_DMLData_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_slave_binlog_DDLData_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_slave_binlog_DDLData_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_slave_binlog_Binlog_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_slave_binlog_Binlog_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

    static {
        String[] descriptorData = {
            "\n\014binlog.proto\022\014slave.binlog\"\214\001\n\006Column\022"
                    + "\026\n\007is_null\030\001 \001(\010:\005false\022\023\n\013int64_value\030\002"
                    + " \001(\003\022\024\n\014uint64_value\030\003 \001(\004\022\024\n\014double_val"
                    + "ue\030\004 \001(\001\022\023\n\013bytes_value\030\005 \001(\014\022\024\n\014string_"
                    + "value\030\006 \001(\t\"F\n\nColumnInfo\022\014\n\004name\030\001 \001(\t\022"
                    + "\022\n\nmysql_type\030\002 \001(\t\022\026\n\016is_primary_key\030\003 "
                    + "\001(\010\",\n\003Row\022%\n\007columns\030\001 \003(\0132\024.slave.binl"
                    + "og.Column\"\217\001\n\005Table\022\023\n\013schema_name\030\001 \001(\t"
                    + "\022\022\n\ntable_name\030\002 \001(\t\022-\n\013column_info\030\003 \003("
                    + "\0132\030.slave.binlog.ColumnInfo\022.\n\tmutations"
                    + "\030\004 \003(\0132\033.slave.binlog.TableMutation\"\200\001\n\r"
                    + "TableMutation\022(\n\004type\030\001 \002(\0162\032.slave.binl"
                    + "og.MutationType\022\036\n\003row\030\002 \002(\0132\021.slave.bin"
                    + "log.Row\022%\n\nchange_row\030\003 \001(\0132\021.slave.binl"
                    + "og.Row\".\n\007DMLData\022#\n\006tables\030\001 \003(\0132\023.slav"
                    + "e.binlog.Table\"E\n\007DDLData\022\023\n\013schema_name"
                    + "\030\001 \001(\t\022\022\n\ntable_name\030\002 \001(\t\022\021\n\tddl_query\030"
                    + "\003 \001(\014\"\225\001\n\006Binlog\022&\n\004type\030\001 \001(\0162\030.slave.b"
                    + "inlog.BinlogType\022\021\n\tcommit_ts\030\002 \001(\003\022\'\n\010d"
                    + "ml_data\030\003 \001(\0132\025.slave.binlog.DMLData\022\'\n\010"
                    + "ddl_data\030\004 \001(\0132\025.slave.binlog.DDLData*2\n"
                    + "\014MutationType\022\n\n\006Insert\020\000\022\n\n\006Update\020\001\022\n\n"
                    + "\006Delete\020\002*\036\n\nBinlogType\022\007\n\003DML\020\000\022\007\n\003DDL\020"
                    + "\001B\030\n\016com.fcbox.moveB\006BinLog"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
                descriptorData, new com.google.protobuf.Descriptors.FileDescriptor[] {}, assigner);
        internal_static_slave_binlog_Column_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_slave_binlog_Column_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_slave_binlog_Column_descriptor,
                        new String[] {
                            "IsNull",
                            "Int64Value",
                            "Uint64Value",
                            "DoubleValue",
                            "BytesValue",
                            "StringValue",
                        });
        internal_static_slave_binlog_ColumnInfo_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_slave_binlog_ColumnInfo_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_slave_binlog_ColumnInfo_descriptor,
                        new String[] {
                            "Name", "MysqlType", "IsPrimaryKey",
                        });
        internal_static_slave_binlog_Row_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_slave_binlog_Row_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_slave_binlog_Row_descriptor,
                        new String[] {
                            "Columns",
                        });
        internal_static_slave_binlog_Table_descriptor = getDescriptor().getMessageTypes().get(3);
        internal_static_slave_binlog_Table_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_slave_binlog_Table_descriptor,
                        new String[] {
                            "SchemaName", "TableName", "ColumnInfo", "Mutations",
                        });
        internal_static_slave_binlog_TableMutation_descriptor =
                getDescriptor().getMessageTypes().get(4);
        internal_static_slave_binlog_TableMutation_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_slave_binlog_TableMutation_descriptor,
                        new String[] {
                            "Type", "Row", "ChangeRow",
                        });
        internal_static_slave_binlog_DMLData_descriptor = getDescriptor().getMessageTypes().get(5);
        internal_static_slave_binlog_DMLData_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_slave_binlog_DMLData_descriptor,
                        new String[] {
                            "Tables",
                        });
        internal_static_slave_binlog_DDLData_descriptor = getDescriptor().getMessageTypes().get(6);
        internal_static_slave_binlog_DDLData_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_slave_binlog_DDLData_descriptor,
                        new String[] {
                            "SchemaName", "TableName", "DdlQuery",
                        });
        internal_static_slave_binlog_Binlog_descriptor = getDescriptor().getMessageTypes().get(7);
        internal_static_slave_binlog_Binlog_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_slave_binlog_Binlog_descriptor,
                        new String[] {
                            "Type", "CommitTs", "DmlData", "DdlData",
                        });
    }

    // @@protoc_insertion_point(outer_class_scope)
}
