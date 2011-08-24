package Controller;

import java.util.ArrayList;

import com.google.protobuf.*;

import Protocol.SenderController.GetMailListRequest;
import Protocol.SenderController.GetMailListResponse;
import Protocol.SenderController.MailStatusRequest;
import Protocol.SenderController.MailStatusResponse;
import Protocol.SenderController.MonitoringRequest;
import Protocol.SenderController.MonitoringResponse;
import Protocol.SenderController.NewTaskRequest;
import Protocol.SenderController.NewTaskResponse;
import Protocol.SenderController.SenderHandler.*;

public class SenderHandler implements BlockingInterface{
	@Override
	public NewTaskResponse newTask(RpcController controller,
			NewTaskRequest request) throws ServiceException {
		int SenderIndex = request.getSenderIndex();
		if(SenderIndex<0 || Controller.Senders.length<=SenderIndex)
			return NewTaskResponse.newBuilder().build();
		if(!Controller.Senders[SenderIndex].Key.equals(request.getSenderKey()))
			return NewTaskResponse.newBuilder().build();
		
		ArrayList<Send_Mail> List = Controller.MongoDB.Load_Mail_List(request.getTime()+1, System.currentTimeMillis());
		String Time="";
		String From="";
		String Subject="";
		String Message="";
		for (Send_Mail send_Mail : List) {
			Time = String.format("%s%s\1", Time,send_Mail.Send_Time);
			From = String.format("%s%s\1", From,send_Mail.From_Adress);
			Subject = String.format("%s%s\1", Subject,send_Mail.Mail_Title);
			Message = String.format("%s%s\1", Message,send_Mail.Mail_Content);
		}
		
		return NewTaskResponse.newBuilder().setTime(Time).setFrom(From).setSubject(Subject).setMessage(Message).build();
	}

	@Override
	public GetMailListResponse getMailList(RpcController controller,
			GetMailListRequest request) throws ServiceException {
		int SenderIndex = request.getSenderIndex();
		if(SenderIndex<0 || Controller.Senders.length<=SenderIndex)
			return GetMailListResponse.newBuilder().build();
		if(!Controller.Senders[SenderIndex].Key.equals(request.getSenderKey()))
			return GetMailListResponse.newBuilder().build();
		
		ArrayList<To_Sender_Person> Person = Controller.MongoDB.Load_Sender_Person(request.getTime(), 10);
		String ObjectId="";
		String Key = "";
		String Address = "";
		for (To_Sender_Person to_Sender_Person : Person) {
			ObjectId = String.format("%s%s\1", ObjectId, to_Sender_Person.ObjectID);
			Key = String.format("%s%d\1", Key, to_Sender_Person.Key);
			Address = String.format("%s%s\1", Address, to_Sender_Person.To_Adress);
		}
		
		if(ObjectId.length()!=0)
		{
			ObjectId = ObjectId.substring(0, ObjectId.length() - 1);
			Key = Key.substring(0, Key.length() - 1);
			Address = Address.substring(0, Address.length() - 1);
		}
		
		return GetMailListResponse.newBuilder().setObjectId(ObjectId).setKey(Key).setAddress(Address).build();
	}

	@Override
	public MailStatusResponse mailStatus(RpcController controller,
			MailStatusRequest request) throws ServiceException {
		int SenderIndex = request.getSenderIndex();
		if(SenderIndex<0 || Controller.Senders.length<=SenderIndex)
			return MailStatusResponse.newBuilder().build();
		if(!Controller.Senders[SenderIndex].Key.equals(request.getSenderKey()))
			return MailStatusResponse.newBuilder().build();

		
		Controller.MongoDB.Update_Cord(request.getTime(), request.getObjectId(), request.getCode()/*, request.getProcessTime()*/);
		System.out.println(request.getCode());
		return MailStatusResponse.newBuilder().build();
	}
	
	@Override
	public MonitoringResponse monitoring(RpcController controller,
			MonitoringRequest request) throws ServiceException {
		int SenderIndex = request.getSenderIndex();
		if(SenderIndex<0 || Controller.Senders.length<=SenderIndex)
			return MonitoringResponse.newBuilder().build();
		if(!Controller.Senders[SenderIndex].Key.equals(request.getSenderKey()))
			return MonitoringResponse.newBuilder().build();
		
		Controller.Senders[SenderIndex].Monitoring.CPU = request.getCPU();
		Controller.Senders[SenderIndex].Monitoring.Memory = request.getMemory();
		Controller.Senders[SenderIndex].Monitoring.NetworkIn_Byte = request.getNetworkInByte();
		Controller.Senders[SenderIndex].Monitoring.NetworkIn_Pakcet = request.getNetworkInPakcet();
		Controller.Senders[SenderIndex].Monitoring.NetworkOut_Byte = request.getNetworkOutByte();
		Controller.Senders[SenderIndex].Monitoring.NetworkOut_Pakcet = request.getNetworkOutPakcet();
		Controller.Senders[SenderIndex].Monitoring.SendCount = request.getSendCount();
		Controller.Senders[SenderIndex].Monitoring.Thread = request.getThread();
		
		// TODO Auto-generated method stub
		//System.out.print(String.format("스레드수 : %d CPU : %f 네트워크 : %d %d 메모리 : %d 초당전송량 : %d\n", request.getThread(), request.getCPU(), request.getNetworkInByte(), request.getNetworkInPakcet(), request.getMemory(), request.getSendCount()));

		return MonitoringResponse.newBuilder().build();
	}
}
