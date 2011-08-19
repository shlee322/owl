package Sender;

import java.util.List;

import com.google.protobuf.ServiceException;

import Protocol.SenderController.GetMailListRequest;
import Protocol.SenderController.GetMailListResponse;

public class Task {
	public String ObjectId;
	public String From;
	public String Subject;
	public String Message;
	public List<Connect> Connects;
	
	public Task(String ObjectId, String From, String Subject, String Message)
	{
		this.ObjectId = ObjectId;
		this.From = From;
		this.Subject = Subject;
		this.Message = Message;
	}
	
	public void Load()
	{
		synchronized(this.Connects)
		{
			if(Connects.size()==0)
			{
				try {
					GetMailListResponse Response = Sender.SenderHandler.getMailList(Sender.controller, GetMailListRequest.newBuilder().setObjectId(this.ObjectId).build());
					if(!Response.getObjectId().equals(""))
					{
						Connect connect = new Connect(this, Response.getObjectId(), Response.getKey(), Response.getAddress());
						this.Connects.add(connect);
						synchronized(Sender.Connect)
						{
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
