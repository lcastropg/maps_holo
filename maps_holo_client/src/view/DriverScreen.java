package view;

import control.NetworkControl;
import control.RequestControl;
import model.DriverProfile;
import model.MSG_Type;
import model.Message;
import model.PSPreferences;
import model.PSRequest;

public class DriverScreen {

	public MSG_Type header;
	public NetworkControl nControl;
	public RequestControl rControl;

	public DriverScreen(MSG_Type header) {
		this.header = header;
		nControl = new NetworkControl();
		rControl = new RequestControl();
	}

	public static void main(String[] args) {

		if (args.length > 0) {

			DriverScreen dScreen = new DriverScreen((args[0].equals("0")) ? MSG_Type.REQUEST_PS : MSG_Type.LEAVING_PS);

			switch (dScreen.header) {
			case REQUEST_PS:
				if (args.length == 6) {
					PSPreferences dPreferences = new PSPreferences(Double.valueOf(args[2]), Double.valueOf(args[3]),
							Integer.valueOf(args[4]), Double.valueOf(args[5]));
					DriverProfile dProfile = new DriverProfile(0, args[1], dPreferences);
					PSRequest psRequest = new PSRequest(dProfile, dPreferences);
					System.out.println("Requesting a PSpace to the system!\n" + dProfile);

					Message msg = dScreen.rControl.packMessage(psRequest, dScreen.header);
					dScreen.nControl.startConnection();
					dScreen.nControl.sendRequest(msg);

					Message msgReceived = dScreen.nControl.waitAnswer();
					System.out.println(dScreen.rControl.unpackMessage(msgReceived));

					if (msgReceived.getHeader().equals(MSG_Type.QUEUE_INFO)) {
						Message msg2 = new Message(MSG_Type.QUEUE_INFO);
						msg2.setContent(dProfile.getDriverName());
						dScreen.nControl.startConnection();
						dScreen.nControl.sendRequest(msg2);
						Message msgReceived2 = dScreen.nControl.waitAnswer();
						System.out.println(dScreen.rControl.unpackMessage(msgReceived2));

						
					}
				} else {
					System.out.println(
							"Wrong input to request a PSpace!\nUse: <0> <name> <price> <weightPrice> <time> <weightTime>");
				}

				break;

			case LEAVING_PS:

				if (args.length == 2) {
					String driverName = args[1];
					System.out.println("Requesting to leave! (Driver: " + driverName + ")");

					Message msg = dScreen.rControl.packMessage(driverName, dScreen.header);
					dScreen.nControl.startConnection();
					dScreen.nControl.sendRequest(msg);
					System.out.println(dScreen.rControl.unpackMessage(dScreen.nControl.waitAnswer()));
				}

				break;

			default:
				System.out.println(
						"Wrong input!\nUse: <0 - Request> <name> <price> <weightPrice> <time> <weightTime> | <1 - Leave>");
				break;
			}
		} else {
			System.out.println(
					"Wrong input!\nUse: <0 - Request> <name> <price> <weightPrice> <time> <weightTime> | <1 - Leave> <name>");
		}

	}

}
