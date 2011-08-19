package Sender;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

class Server
{
	public int ranking=0;
	public String Host="";
	public InetAddress Address=null;
	
	public InetAddress getHost()
	{
		if(Address == null)
		{
			try {
				Address = InetAddress.getByName(Host);
			} catch (UnknownHostException e) {
				e.printStackTrace();
				return null;
			}
		}
		return Address;
	}
}

public class DNS {
	Server[] Server;
}
