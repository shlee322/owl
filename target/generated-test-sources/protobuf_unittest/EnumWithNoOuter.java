// Generated by the protocol buffer compiler.  DO NOT EDIT!

package protobuf_unittest;

public enum EnumWithNoOuter
    implements com.google.protobuf.ProtocolMessageEnum {
  FOO(0, 1),
  BAR(1, 2),
  ;
  
  
  public final int getNumber() { return value; }
  
  public static EnumWithNoOuter valueOf(int value) {
    switch (value) {
      case 1: return FOO;
      case 2: return BAR;
      default: return null;
    }
  }
  
  public static com.google.protobuf.Internal.EnumLiteMap<EnumWithNoOuter>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static com.google.protobuf.Internal.EnumLiteMap<EnumWithNoOuter>
      internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EnumWithNoOuter>() {
          public EnumWithNoOuter findValueByNumber(int number) {
            return EnumWithNoOuter.valueOf(number)
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
    return protobuf_unittest.MultipleFilesTestProto.getDescriptor().getEnumTypes().get(0);
  }
  
  private static final EnumWithNoOuter[] VALUES = {
    FOO, BAR, 
  };
  public static EnumWithNoOuter valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }
  private final int index;
  private final int value;
  private EnumWithNoOuter(int index, int value) {
    this.index = index;
    this.value = value;
  }
  
  static {
    protobuf_unittest.MultipleFilesTestProto.getDescriptor();
  }
  
  // @@protoc_insertion_point(enum_scope:protobuf_unittest.EnumWithNoOuter)
}

