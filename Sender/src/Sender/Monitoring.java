package Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Monitoring {
	static long time=0;
	static long sendcount=0;
	static long temp_sendcount=0;
	static public void Run()
	{
		String Network = Monitoring.Network();
		
		if(System.currentTimeMillis()<=time)
			return;
		time=System.currentTimeMillis()+500;
		
		String CPU = Monitoring.CPU();
		
		long scount = sendcount + temp_sendcount;
		temp_sendcount = sendcount;
		sendcount = 0;

		System.out.println(String.format("스레드수 : %d CPU : %s 네트워크 : %s 메모리 : %d 초당전송량 : %d", Thread.activeCount(), CPU, Network, usedMemory(), scount));
	}
	
	static private String Network()
	{
		Process p = null;
		
		try {
			p = Runtime.getRuntime().exec("ifstat -nq -i eth0 0.5 1|tail -n1");
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
			String line2="";
			while ((line2 = reader.readLine()) != null) {
				line += line2;
			}
			//line = reader.readLine();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return line;
	}
	
	static private String CPU()
	{
		Process p = null;
		
		try {
			p = Runtime.getRuntime().exec("top -n1 -b | head -n3 | tail -n1");
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
		return line;
	}
	
	static private long usedMemory()
	{
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
}
