package Sender;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.ServiceException;

import Protocol.SenderController.GetMailListRequest;
import Protocol.SenderController.GetMailListResponse;

public class Task {
	public long Time;
	public String From;
	public String Subject;
	public String Message;
	public List<Connect> Connects;
	
	public Task(long Time, String From, String Subject, String Message)
	{
		this.Time = Time;
		this.From = From;
		this.Subject = Subject;
		this.Message = Message;
		this.Connects = new ArrayList<Connect>();
	}
	
	public void Load(Connect c)
	{
		synchronized(this.Connects)
		{
			if(c!=null)
				this.Connects.remove(c);
			
			if(this.Connects.size()==0)
			{
				try {
					GetMailListResponse Response = Sender.SenderHandler.getMailList(Sender.controller, GetMailListRequest.newBuilder().setSenderIndex(Sender.SenderIndex).setSenderKey(Sender.SenderKey).setTime(this.Time).build());
					if(Response.getObjectId().equals(""))
						return;
					String[] ObjectId=Response.getObjectId().split("\1");
					String[] Key = Response.getKey().split("\1");
					String[] Address = Response.getAddress().split("\1");
					
					synchronized(Sender.Connect)
					{
						for(int i=0; i<ObjectId.length; i++)
						{
							Connect connect = new Connect(this, ObjectId[i], Key[i], Address[i]);
							this.Connects.add(connect);
							Sender.Connect.add(connect);
						}
					}
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
