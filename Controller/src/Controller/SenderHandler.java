package Controller;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetMailListResponse getMailList(RpcController controller,
			GetMailListRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MailStatusResponse mailStatus(RpcController controller,
			MailStatusRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public MonitoringResponse monitoring(RpcController controller,
			MonitoringRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		//System.out.print(String.format("스레드수 : %d CPU : %f 네트워크 : %d %d 메모리 : %d 초당전송량 : %d\n", request.getThread(), request.getCPU(), request.getNetworkInByte(), request.getNetworkInPakcet(), request.getMemory(), request.getSendCount()));

		return MonitoringResponse.newBuilder().build();
	}
}
