package client;

import java.nio.ByteBuffer;

import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.*;

import controlApi.mailSet;

public class apiClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		int timeout = 10*1000;
		final TSocket socket = new TSocket("127.0.0.1",9099);
		socket.setTimeout(timeout);
		
		final TTransport transport = new TFramedTransport(socket);
		final TProtocol protocol = new TBinaryProtocol(transport);
		final controlApi.controlApi.Client client = new controlApi.controlApi.Client(protocol);
		String sendDate = "2011.07.28";
		transport.open();
		
		common.ServiceStatus serverStatus = client.getServiceStatus();
		
		System.out.println(serverStatus.getHostName()+ ":" + serverStatus.getPort()+" status : " + serverStatus.getStatus());
		
		mailSet mailset = new mailSet();
		mailset.setAddressBook(ByteBuffer.wrap("this might be address".getBytes()));
		mailset.setSenderAddress("toori67@gmail.com");
		mailset.setTemplate("<p>adwdwced<p>");
		mailset.setWhenToSend(sendDate);
		client.sendMailSet(mailset);
		
		System.out.println(client.getStatic(sendDate));
		System.out.println(client.getStatic(sendDate));
		System.out.println(client.getStatic(sendDate));
		System.out.println(client.getStatic(sendDate));
	}

}
