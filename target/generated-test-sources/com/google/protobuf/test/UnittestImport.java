// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/protobuf/unittest_import.proto

package com.google.protobuf.test;

public final class UnittestImport {
  private UnittestImport() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public enum ImportEnum
      implements com.google.protobuf.ProtocolMessageEnum {
    IMPORT_FOO(0, 7),
    IMPORT_BAR(1, 8),
    IMPORT_BAZ(2, 9),
    ;
    
    
    public final int getNumber() { return value; }
    
    public static ImportEnum valueOf(int value) {
      switch (value) {
        case 7: return IMPORT_FOO;
        case 8: return IMPORT_BAR;
        case 9: return IMPORT_BAZ;
        default: return null;
      }
    }
    
    public static com.google.protobuf.Internal.EnumLiteMap<ImportEnum>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<ImportEnum>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<ImportEnum>() {
            public ImportEnum findValueByNumber(int number) {
              return ImportEnum.valueOf(number)
    ;        }
          };
    
    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.google.protobuf.test.UnittestImport.getDescriptor().getEnumTypes().get(0);
    }
    
    private static final ImportEnum[] VALUES = {
      IMPORT_FOO, IMPORT_BAR, IMPORT_BAZ, 
    };
    public static ImportEnum valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }
    private final int index;
    private final int value;
    private ImportEnum(int index, int value) {
      this.index = index;
      this.value = value;
    }
    
    static {
      com.google.protobuf.test.UnittestImport.getDescriptor();
    }
    
    // @@protoc_insertion_point(enum_scope:protobuf_unittest_import.ImportEnum)
  }
  
  public static final class ImportMessage extends
      com.google.protobuf.GeneratedMessage {
    // Use ImportMessage.newBuilder() to construct.
    private ImportMessage() {
      initFields();
    }
    private ImportMessage(boolean noInit) {}
    
    private static final ImportMessage defaultInstance;
    public static ImportMessage getDefaultInstance() {
      return defaultInstance;
    }
    
    public ImportMessage getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.protobuf.test.UnittestImport.internal_static_protobuf_unittest_import_ImportMessage_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.protobuf.test.UnittestImport.internal_static_protobuf_unittest_import_ImportMessage_fieldAccessorTable;
    }
    
    // optional int32 d = 1;
    public static final int D_FIELD_NUMBER = 1;
    private boolean hasD;
    private int d_ = 0;
    public boolean hasD() { return hasD; }
    public int getD() { return d_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasD()) {
        output.writeInt32(1, getD());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasD()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, getD());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.google.protobuf.test.UnittestImport.ImportMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.google.protobuf.test.UnittestImport.ImportMessage prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.google.protobuf.test.UnittestImport.ImportMessage result;
      
      // Construct using com.google.protobuf.test.UnittestImport.ImportMessage.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.google.protobuf.test.UnittestImport.ImportMessage();
        return builder;
      }
      
      protected com.google.protobuf.test.UnittestImport.ImportMessage internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.google.protobuf.test.UnittestImport.ImportMessage();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.google.protobuf.test.UnittestImport.ImportMessage.getDescriptor();
      }
      
      public com.google.protobuf.test.UnittestImport.ImportMessage getDefaultInstanceForType() {
        return com.google.protobuf.test.UnittestImport.ImportMessage.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.google.protobuf.test.UnittestImport.ImportMessage build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.google.protobuf.test.UnittestImport.ImportMessage buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.google.protobuf.test.UnittestImport.ImportMessage buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.google.protobuf.test.UnittestImport.ImportMessage returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.google.protobuf.test.UnittestImport.ImportMessage) {
          return mergeFrom((com.google.protobuf.test.UnittestImport.ImportMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.google.protobuf.test.UnittestImport.ImportMessage other) {
        if (other == com.google.protobuf.test.UnittestImport.ImportMessage.getDefaultInstance()) return this;
        if (other.hasD()) {
          setD(other.getD());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 8: {
              setD(input.readInt32());
              break;
            }
          }
        }
      }
      
      
      // optional int32 d = 1;
      public boolean hasD() {
        return result.hasD();
      }
      public int getD() {
        return result.getD();
      }
      public Builder setD(int value) {
        result.hasD = true;
        result.d_ = value;
        return this;
      }
      public Builder clearD() {
        result.hasD = false;
        result.d_ = 0;
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:protobuf_unittest_import.ImportMessage)
    }
    
    static {
      defaultInstance = new ImportMessage(true);
      com.google.protobuf.test.UnittestImport.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:protobuf_unittest_import.ImportMessage)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_protobuf_unittest_import_ImportMessage_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_protobuf_unittest_import_ImportMessage_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n%google/protobuf/unittest_import.proto\022" +
      "\030protobuf_unittest_import\"\032\n\rImportMessa" +
      "ge\022\t\n\001d\030\001 \001(\005*<\n\nImportEnum\022\016\n\nIMPORT_FO" +
      "O\020\007\022\016\n\nIMPORT_BAR\020\010\022\016\n\nIMPORT_BAZ\020\tB\034\n\030c" +
      "om.google.protobuf.testH\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_protobuf_unittest_import_ImportMessage_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_protobuf_unittest_import_ImportMessage_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_protobuf_unittest_import_ImportMessage_descriptor,
              new java.lang.String[] { "D", },
              com.google.protobuf.test.UnittestImport.ImportMessage.class,
              com.google.protobuf.test.UnittestImport.ImportMessage.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}
