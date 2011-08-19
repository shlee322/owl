package Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Monitoring extends Thread {
	long time=0;
	
	static long sendcount=0;
	long temp_sendcount=0;
	
	class NetworkMonitoring
	{
		public long receive_byte=0;
		public long receive_pakcet=0;
		public long transmit_byte=0;
		public long transmit_packet=0;
	}
	
	NetworkMonitoring LastNetworkMonitoring = new NetworkMonitoring();
	
	public void run()
    {
		while(true)
		{
			if(System.currentTimeMillis()<=time)
				continue;
			time=System.currentTimeMillis()+500;
			
			NetworkMonitoring Net = this.Network();
			double cpustat = this.CPU();
			
			long scount = sendcount + temp_sendcount;
			temp_sendcount = sendcount;
			sendcount = 0;
	
			for (int i = 0; i < 80; i++)
			      System.out.println("");
			System.out.print(String.format("스레드수 : %d CPU : %f 네트워크 : %d %d 메모리 : %d 초당전송량 : %d\n", Thread.activeCount(), cpustat, Net.receive_byte, Net.transmit_byte, usedMemory(), scount));
		}
	}
	
	private NetworkMonitoring Network()
	{
		Process p = null;
		
		try {
			p = Runtime.getRuntime().exec(new String[]{"sh","network.sh"});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			p.waitFor();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		NetworkMonitoring NetworkData = new NetworkMonitoring();
		
		BufferedReader reader;
		
		reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		String line="";
		try {
			line = reader.readLine();
			String []data = line.split(" ");
			
			NetworkData.receive_byte = Long.parseLong(data[0]);
			NetworkData.receive_pakcet = Long.parseLong(data[1]);
			NetworkData.transmit_byte = Long.parseLong(data[2]);
			NetworkData.transmit_packet = Long.parseLong(data[3]);
			
			NetworkMonitoring Temp = LastNetworkMonitoring;
			LastNetworkMonitoring = NetworkData;
			Temp.receive_byte = NetworkData.receive_byte - Temp.receive_byte;
			Temp.receive_pakcet = NetworkData.receive_pakcet - Temp.receive_pakcet;
			Temp.transmit_byte = NetworkData.transmit_byte - Temp.transmit_byte;
			Temp.transmit_packet = NetworkData.transmit_packet - Temp.transmit_packet;
			
			return Temp;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private double CPU()
	{
		Process p = null;
		
		try {
			p = Runtime.getRuntime().exec(new String[]{"sh","cpu.sh"});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			p.waitFor();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line="";
		try {
			line = reader.readLine();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Double.parseDouble(line);
	}
	
	private long usedMemory()
	{
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
}
