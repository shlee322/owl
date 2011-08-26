package apiServer;

import java.io.*;
import java.net.InetAddress;
import java.util.*;

import org.apache.thrift.server.*;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.*;


import mailClient.api.java.controlApi;

public class thriftApiServer {

	
	public static int PORT;
	public static thriftApiServer apiserver;
	
	private String hostName;
	private thriftApiServerHandler thriftApiService;
	
	public thriftApiServer() {
		thriftApiService = new thriftApiServerHandler(this);
	}	
	public String getHostName() {
		return hostName;
	}
	public int getPort() { 
		return PORT;
	}
	public thriftApiServerHandler getThriftApiService() {
		return thriftApiService;
	}
	public void startapiServer() throws Exception {
		startThriftServer();
	}


	
	private void startThriftServer() throws Exception{
		this.hostName = InetAddress.getLocalHost().getHostName();
		final TNonblockingServerSocket socket = new TNonblockingServerSocket(PORT);
		final controlApi.Processor processor = new controlApi.Processor(thriftApiService);
		final TServer server = new THsHaServer(processor, socket, new TFramedTransport.Factory(), new TBinaryProtocol.Factory());

		System.out.println("thriftApiServer started(Port: "+PORT+")");
		logging.logging.debug("debug");
		server.serve();
	}
	
	public static void thniftApiServerMain(String[] args) throws Exception  {
		logging logger = new logging();
		logger.startLogging();
		
		
		Properties properties = new Properties();
		try {
			FileInputStream properties_file;
			properties_file = new FileInputStream("setting.properties");
			properties.load(properties_file);
			properties_file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PORT = Integer.parseInt(properties.getProperty("PORT"));
		apiserver = new thriftApiServer();
		apiserver.startapiServer();
	}

}
