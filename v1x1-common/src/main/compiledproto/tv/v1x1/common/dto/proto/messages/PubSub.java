// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PubSub.proto

package tv.v1x1.common.dto.proto.messages;

public final class PubSub {
  private PubSub() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
    registry.add(tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.data);
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PubSubMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:tv.v1x1.common.dto.proto.messages.PubSubMessage)
      com.google.protobuf.GeneratedMessageV3.
          ExtendableMessageOrBuilder<PubSubMessage> {

    /**
     * <code>required string topic = 1;</code>
     */
    boolean hasTopic();
    /**
     * <code>required string topic = 1;</code>
     */
    java.lang.String getTopic();
    /**
     * <code>required string topic = 1;</code>
     */
    com.google.protobuf.ByteString
        getTopicBytes();

    /**
     * <code>required string json = 2;</code>
     */
    boolean hasJson();
    /**
     * <code>required string json = 2;</code>
     */
    java.lang.String getJson();
    /**
     * <code>required string json = 2;</code>
     */
    com.google.protobuf.ByteString
        getJsonBytes();
  }
  /**
   * Protobuf type {@code tv.v1x1.common.dto.proto.messages.PubSubMessage}
   */
  public  static final class PubSubMessage extends
      com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
        PubSubMessage> implements
      // @@protoc_insertion_point(message_implements:tv.v1x1.common.dto.proto.messages.PubSubMessage)
      PubSubMessageOrBuilder {
    // Use PubSubMessage.newBuilder() to construct.
    private PubSubMessage(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage, ?> builder) {
      super(builder);
    }
    private PubSubMessage() {
      topic_ = "";
      json_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private PubSubMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              topic_ = bs;
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              json_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return tv.v1x1.common.dto.proto.messages.PubSub.internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return tv.v1x1.common.dto.proto.messages.PubSub.internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.class, tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.Builder.class);
    }

    private int bitField0_;
    public static final int TOPIC_FIELD_NUMBER = 1;
    private volatile java.lang.Object topic_;
    /**
     * <code>required string topic = 1;</code>
     */
    public boolean hasTopic() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string topic = 1;</code>
     */
    public java.lang.String getTopic() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          topic_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string topic = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTopicBytes() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        topic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int JSON_FIELD_NUMBER = 2;
    private volatile java.lang.Object json_;
    /**
     * <code>required string json = 2;</code>
     */
    public boolean hasJson() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string json = 2;</code>
     */
    public java.lang.String getJson() {
      java.lang.Object ref = json_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          json_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string json = 2;</code>
     */
    public com.google.protobuf.ByteString
        getJsonBytes() {
      java.lang.Object ref = json_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        json_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasTopic()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasJson()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!extensionsAreInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      com.google.protobuf.GeneratedMessageV3
        .ExtendableMessage<tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage>.ExtensionWriter
          extensionWriter = newExtensionWriter();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, topic_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, json_);
      }
      extensionWriter.writeUntil(536870912, output);
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, topic_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, json_);
      }
      size += extensionsSerializedSize();
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage)) {
        return super.equals(obj);
      }
      tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage other = (tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage) obj;

      boolean result = true;
      result = result && (hasTopic() == other.hasTopic());
      if (hasTopic()) {
        result = result && getTopic()
            .equals(other.getTopic());
      }
      result = result && (hasJson() == other.hasJson());
      if (hasJson()) {
        result = result && getJson()
            .equals(other.getJson());
      }
      result = result && unknownFields.equals(other.unknownFields);
      result = result &&
          getExtensionFields().equals(other.getExtensionFields());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (hasTopic()) {
        hash = (37 * hash) + TOPIC_FIELD_NUMBER;
        hash = (53 * hash) + getTopic().hashCode();
      }
      if (hasJson()) {
        hash = (37 * hash) + JSON_FIELD_NUMBER;
        hash = (53 * hash) + getJson().hashCode();
      }
      hash = hashFields(hash, getExtensionFields());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code tv.v1x1.common.dto.proto.messages.PubSubMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
          tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage, Builder> implements
        // @@protoc_insertion_point(builder_implements:tv.v1x1.common.dto.proto.messages.PubSubMessage)
        tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return tv.v1x1.common.dto.proto.messages.PubSub.internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return tv.v1x1.common.dto.proto.messages.PubSub.internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.class, tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.Builder.class);
      }

      // Construct using tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        topic_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        json_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return tv.v1x1.common.dto.proto.messages.PubSub.internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_descriptor;
      }

      public tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage getDefaultInstanceForType() {
        return tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.getDefaultInstance();
      }

      public tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage build() {
        tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage buildPartial() {
        tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage result = new tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.topic_ = topic_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.json_ = json_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public <Type> Builder setExtension(
          com.google.protobuf.GeneratedMessage.GeneratedExtension<
              tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage, Type> extension,
          Type value) {
        return (Builder) super.setExtension(extension, value);
      }
      public <Type> Builder setExtension(
          com.google.protobuf.GeneratedMessage.GeneratedExtension<
              tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage, java.util.List<Type>> extension,
          int index, Type value) {
        return (Builder) super.setExtension(extension, index, value);
      }
      public <Type> Builder addExtension(
          com.google.protobuf.GeneratedMessage.GeneratedExtension<
              tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage, java.util.List<Type>> extension,
          Type value) {
        return (Builder) super.addExtension(extension, value);
      }
      public <Type> Builder clearExtension(
          com.google.protobuf.GeneratedMessage.GeneratedExtension<
              tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage, ?> extension) {
        return (Builder) super.clearExtension(extension);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage) {
          return mergeFrom((tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage other) {
        if (other == tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.getDefaultInstance()) return this;
        if (other.hasTopic()) {
          bitField0_ |= 0x00000001;
          topic_ = other.topic_;
          onChanged();
        }
        if (other.hasJson()) {
          bitField0_ |= 0x00000002;
          json_ = other.json_;
          onChanged();
        }
        this.mergeExtensionFields(other);
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasTopic()) {
          return false;
        }
        if (!hasJson()) {
          return false;
        }
        if (!extensionsAreInitialized()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object topic_ = "";
      /**
       * <code>required string topic = 1;</code>
       */
      public boolean hasTopic() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public java.lang.String getTopic() {
        java.lang.Object ref = topic_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            topic_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public com.google.protobuf.ByteString
          getTopicBytes() {
        java.lang.Object ref = topic_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          topic_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder setTopic(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder clearTopic() {
        bitField0_ = (bitField0_ & ~0x00000001);
        topic_ = getDefaultInstance().getTopic();
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder setTopicBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object json_ = "";
      /**
       * <code>required string json = 2;</code>
       */
      public boolean hasJson() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string json = 2;</code>
       */
      public java.lang.String getJson() {
        java.lang.Object ref = json_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            json_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string json = 2;</code>
       */
      public com.google.protobuf.ByteString
          getJsonBytes() {
        java.lang.Object ref = json_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          json_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string json = 2;</code>
       */
      public Builder setJson(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        json_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string json = 2;</code>
       */
      public Builder clearJson() {
        bitField0_ = (bitField0_ & ~0x00000002);
        json_ = getDefaultInstance().getJson();
        onChanged();
        return this;
      }
      /**
       * <code>required string json = 2;</code>
       */
      public Builder setJsonBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        json_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:tv.v1x1.common.dto.proto.messages.PubSubMessage)
    }

    // @@protoc_insertion_point(class_scope:tv.v1x1.common.dto.proto.messages.PubSubMessage)
    private static final tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage();
    }

    public static tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<PubSubMessage>
        PARSER = new com.google.protobuf.AbstractParser<PubSubMessage>() {
      public PubSubMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new PubSubMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PubSubMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PubSubMessage> getParserForType() {
      return PARSER;
    }

    public tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

    public static final int DATA_FIELD_NUMBER = 104;
    /**
     * <code>extend .tv.v1x1.common.dto.proto.messages.Message { ... }</code>
     */
    public static final
      com.google.protobuf.GeneratedMessage.GeneratedExtension<
        tv.v1x1.common.dto.proto.messages.MessageOuterClass.Message,
        tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage> data = com.google.protobuf.GeneratedMessage
            .newMessageScopedGeneratedExtension(
          tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.getDefaultInstance(),
          0,
          tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.class,
          tv.v1x1.common.dto.proto.messages.PubSub.PubSubMessage.getDefaultInstance());
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014PubSub.proto\022!tv.v1x1.common.dto.proto" +
      ".messages\032\rMessage.proto\"\242\001\n\rPubSubMessa" +
      "ge\022\r\n\005topic\030\001 \002(\t\022\014\n\004json\030\002 \002(\t*\010\010d\020\200\200\200\200" +
      "\0022j\n\004data\022*.tv.v1x1.common.dto.proto.mes" +
      "sages.Message\030h \001(\01320.tv.v1x1.common.dto" +
      ".proto.messages.PubSubMessage"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          tv.v1x1.common.dto.proto.messages.MessageOuterClass.getDescriptor(),
        }, assigner);
    internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tv_v1x1_common_dto_proto_messages_PubSubMessage_descriptor,
        new java.lang.String[] { "Topic", "Json", });
    tv.v1x1.common.dto.proto.messages.MessageOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
