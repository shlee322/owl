package Controller;

import com.google.protobuf.*;

import Protocol.SenderController.CertifyRequest;
import Protocol.SenderController.CertifyResponse;
import Protocol.SenderController.GetMailListRequest;
import Protocol.SenderController.GetMailListResponse;
import Protocol.SenderController.GetMailStatusRequest;
import Protocol.SenderController.GetMailStatusResponse;
import Protocol.SenderController.MonitoringRequest;
import Protocol.SenderController.MonitoringResponse;
import Protocol.SenderController.NewTaskRequest;
import Protocol.SenderController.NewTaskResponse;
import Protocol.SenderController.SenderHandler.*;
import Protocol.SenderController.*;

public class SenderHandler implements Interface{

	@Override
	public void certify(RpcController controller, CertifyRequest request,
			RpcCallback<CertifyResponse> done) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newTask(RpcController controller, NewTaskRequest request,
			RpcCallback<NewTaskResponse> done) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void getMailList(RpcController controller,
			GetMailListRequest request, RpcCallback<GetMailListResponse> done) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMailStatus(RpcController controller,
			GetMailStatusRequest request,
			RpcCallback<GetMailStatusResponse> done) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void monitoring(RpcController controller, MonitoringRequest request,
			RpcCallback<MonitoringResponse> done) {
		// TODO Auto-generated method stub
		
	}
}
