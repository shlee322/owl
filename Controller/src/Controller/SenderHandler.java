package Controller;

import Protocol.SenderController.SenderHandler.*;

public class SenderHandler implements Interface{
	public void add(RpcController controller, CalcRequest request,
            RpcCallback<CalcResponse> done) {
    CalcResponse response = null;
    try {
            response = add(controller, request);
    } catch (ServiceException e) { }
    if (done != null) {
            done.run(response);
    } else {
            // Since no callback registered, might as well spit out the
            // answer here otherwise we'll never know what happened
            if (response == null)
                    logger.info("Error occured");
            else
                    logger.info("Answer is: " + response.getResult());
    }
}
}
