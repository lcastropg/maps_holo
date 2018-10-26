package control;

import model.MSG_Type;
import model.Message;
import model.PSOffer;
import model.PSRequest;

public class RequestControl {

	public String unpackMessage(Message msg2Unpack) {

		String unpackedMessage = null;
		
		switch (msg2Unpack.getHeader()) {
		case PS_INFO:			
			PSOffer psOffer = (PSOffer) msg2Unpack.getContent();
			unpackedMessage = psOffer.toString();
			break;
		case QUEUE_INFO:
			unpackedMessage = (String) msg2Unpack.getContent();
			break;
		case PAYMENT_INFO:
			unpackedMessage = "Price: $" + String.format("%.2f", Double.valueOf(msg2Unpack.getContent().toString()));
			break;
		case UNAVAILABLE_SYS:
			unpackedMessage = (String) msg2Unpack.getContent();
			break;
		default:
			break;
		}
		
		return unpackedMessage;

	}

	public Message packMessage(PSRequest psRequest, MSG_Type header) {

		Message msg2Pack = new Message(header);

		switch (header) {
		case REQUEST_PS:
			msg2Pack.setContent(psRequest);
			break;
		case LEAVING_PS:
			//msg2Pack.setContent(psRequest.getdProfile());
			break;
		default:
			break;
		}

		return msg2Pack;
	}
	
	public Message packMessage(String msg, MSG_Type header) {

		Message msg2Pack = new Message(header);

		switch (header) {
		case REQUEST_PS:
			msg2Pack.setContent(msg);
			break;
		case LEAVING_PS:
			msg2Pack.setContent(msg);
			break;
		default:
			break;
		}

		return msg2Pack;
	}


}
