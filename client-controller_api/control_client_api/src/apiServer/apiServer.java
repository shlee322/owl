package apiServer;

import java.net.InetAddress;

import org.apache.thrift.protocol.*;
import org.apache.thrift.server.*;
import org.apache.thrift.transport.*;

public class apiServer {
	public static final int PORT = 9099;
	public static apiServer apiserver;
	
	private String hostName;
	private apiServerHandler apiService;
	
	public apiServer(){
		apiService = new apiServerHandler(this);
	}
	
	public String getHostName() {
		return hostName;
	}
	public int getPort() {
		return PORT;
	}
	public void startApiServer() throws Exception {
		startThriftServer();
	}
	
	private void startThriftServer() throws Exception {
		this.hostName = InetAddress.getLocalHost().getHostName();
		 final TNonblockingServerSocket socket = new TNonblockingServerSocket(PORT);
		 final controlApi.controlApi.Processor processor = new controlApi.controlApi.Processor(apiService);
		 final TServer server = new THsHaServer(processor, socket, new TFramedTransport.Factory(), new TBinaryProtocol.Factory());
		 
		 System.out.println("Api server started (port: "+PORT+")");
		 server.serve();
	}

	public static void main(String[] args) throws Exception {
		apiserver = new apiServer();
		apiserver.startApiServer();
	}
}
