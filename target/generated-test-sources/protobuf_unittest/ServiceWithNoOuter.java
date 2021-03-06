// Generated by the protocol buffer compiler.  DO NOT EDIT!

package protobuf_unittest;

public  abstract class ServiceWithNoOuter
    implements com.google.protobuf.Service {
  protected ServiceWithNoOuter() {}
  
  public interface Interface {
    public abstract void foo(
        com.google.protobuf.RpcController controller,
        protobuf_unittest.MessageWithNoOuter request,
        com.google.protobuf.RpcCallback<protobuf_unittest.UnittestProto.TestAllTypes> done);
    
  }
  
  public static com.google.protobuf.Service newReflectiveService(
      final Interface impl) {
    return new ServiceWithNoOuter() {
      @Override
      public  void foo(
          com.google.protobuf.RpcController controller,
          protobuf_unittest.MessageWithNoOuter request,
          com.google.protobuf.RpcCallback<protobuf_unittest.UnittestProto.TestAllTypes> done) {
        impl.foo(controller, request, done);
      }
      
    };
  }
  
  public static com.google.protobuf.BlockingService
      newReflectiveBlockingService(final BlockingInterface impl) {
    return new com.google.protobuf.BlockingService() {
      public final com.google.protobuf.Descriptors.ServiceDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      
      public final com.google.protobuf.Message callBlockingMethod(
          com.google.protobuf.Descriptors.MethodDescriptor method,
          com.google.protobuf.RpcController controller,
          com.google.protobuf.Message request)
          throws com.google.protobuf.ServiceException {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.callBlockingMethod() given method descriptor for " +
            "wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return impl.foo(controller, (protobuf_unittest.MessageWithNoOuter)request);
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }
      
      public final com.google.protobuf.Message
          getRequestPrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getRequestPrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return protobuf_unittest.MessageWithNoOuter.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }
      
      public final com.google.protobuf.Message
          getResponsePrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getResponsePrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return protobuf_unittest.UnittestProto.TestAllTypes.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }
      
    };
  }
  
  public abstract void foo(
      com.google.protobuf.RpcController controller,
      protobuf_unittest.MessageWithNoOuter request,
      com.google.protobuf.RpcCallback<protobuf_unittest.UnittestProto.TestAllTypes> done);
  
  public static final
      com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptor() {
    return protobuf_unittest.MultipleFilesTestProto.getDescriptor().getServices().get(0);
  }
  public final com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  
  public final void callMethod(
      com.google.protobuf.Descriptors.MethodDescriptor method,
      com.google.protobuf.RpcController controller,
      com.google.protobuf.Message request,
      com.google.protobuf.RpcCallback<
        com.google.protobuf.Message> done) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.callMethod() given method descriptor for wrong " +
        "service type.");
    }
    switch(method.getIndex()) {
      case 0:
        this.foo(controller, (protobuf_unittest.MessageWithNoOuter)request,
          com.google.protobuf.RpcUtil.<protobuf_unittest.UnittestProto.TestAllTypes>specializeCallback(
            done));
        return;
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }
  
  public final com.google.protobuf.Message
      getRequestPrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getRequestPrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return protobuf_unittest.MessageWithNoOuter.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }
  
  public final com.google.protobuf.Message
      getResponsePrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getResponsePrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return protobuf_unittest.UnittestProto.TestAllTypes.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }
  
  public static Stub newStub(
      com.google.protobuf.RpcChannel channel) {
    return new Stub(channel);
  }
  
  public static final class Stub extends protobuf_unittest.ServiceWithNoOuter implements Interface {
    private Stub(com.google.protobuf.RpcChannel channel) {
      this.channel = channel;
    }
    
    private final com.google.protobuf.RpcChannel channel;
    
    public com.google.protobuf.RpcChannel getChannel() {
      return channel;
    }
    
    public  void foo(
        com.google.protobuf.RpcController controller,
        protobuf_unittest.MessageWithNoOuter request,
        com.google.protobuf.RpcCallback<protobuf_unittest.UnittestProto.TestAllTypes> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        protobuf_unittest.UnittestProto.TestAllTypes.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          protobuf_unittest.UnittestProto.TestAllTypes.class,
          protobuf_unittest.UnittestProto.TestAllTypes.getDefaultInstance()));
    }
  }
  
  public static BlockingInterface newBlockingStub(
      com.google.protobuf.BlockingRpcChannel channel) {
    return new BlockingStub(channel);
  }
  
  public interface BlockingInterface {
    public protobuf_unittest.UnittestProto.TestAllTypes foo(
        com.google.protobuf.RpcController controller,
        protobuf_unittest.MessageWithNoOuter request)
        throws com.google.protobuf.ServiceException;
  }
  
  private static final class BlockingStub implements BlockingInterface {
    private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
      this.channel = channel;
    }
    
    private final com.google.protobuf.BlockingRpcChannel channel;
    
    public protobuf_unittest.UnittestProto.TestAllTypes foo(
        com.google.protobuf.RpcController controller,
        protobuf_unittest.MessageWithNoOuter request)
        throws com.google.protobuf.ServiceException {
      return (protobuf_unittest.UnittestProto.TestAllTypes) channel.callBlockingMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        protobuf_unittest.UnittestProto.TestAllTypes.getDefaultInstance());
    }
    
  }
}

