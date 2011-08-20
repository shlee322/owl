package Controller;

import java.util.ArrayList;

import com.google.protobuf.*;

import Protocol.SenderController.CertifyRequest;
import Protocol.SenderController.CertifyResponse;
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
	public CertifyResponse certify(RpcController controller,
			CertifyRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewTaskResponse newTask(RpcController controller,
			NewTaskRequest request) throws ServiceException {
		ArrayList<Send_Mail> List = Controller.MongoDB.Load_Mail_List(request.getTime(), 1);
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
		ArrayList<To_Sender_Person> Person = Controller.MongoDB.Load_Sender_Person(request.getTime(), 10);
		String ObjectId="";
		String Key = "";
		String Address = "";
		for (To_Sender_Person to_Sender_Person : Person) {
			ObjectId = String.format("%s%s\1", ObjectId, to_Sender_Person.ObjectID);
			Key = String.format("%s%d\1", Key, to_Sender_Person.Key);
			Address = String.format("%s%s\1", Address, to_Sender_Person.To_Adress);
		}
		
		return GetMailListResponse.newBuilder().setObjectId(ObjectId).setKey(Key).setAddress(Address).build();
	}

	@Override
	public MailStatusResponse mailStatus(RpcController controller,
			MailStatusRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		Controller.MongoDB.Update_Cord(request.getTime(), request.getObjectId(), request.getCode());
		System.out.println(request.getCode());
		return MailStatusResponse.newBuilder().build();
	}
	
	@Override
	public MonitoringResponse monitoring(RpcController controller,
			MonitoringRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		//System.out.print(String.format("스레드수 : %d CPU : %f 네트워크 : %d %d 메모리 : %d 초당전송량 : %d\n", request.getThread(), request.getCPU(), request.getNetworkInByte(), request.getNetworkInPakcet(), request.getMemory(), request.getSendCount()));

		return MonitoringResponse.newBuilder().build();
	}
}
