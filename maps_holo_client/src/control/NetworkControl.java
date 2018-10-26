package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Message;
import model.NetworkConfig;

public class NetworkControl {

	public Socket clientSocket;
	public ObjectInputStream inputStream;
	public ObjectOutputStream outputStream;
	public Object streamObject;

	public boolean startConnection() {
		try {
			clientSocket = new Socket(NetworkConfig.SERVER_IP.getValue(),
					Integer.valueOf(NetworkConfig.SERVER_PORT.getValue()));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void sendRequest(Message obj2Send) {
		try {
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			outputStream.writeObject(obj2Send);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Message waitAnswer() {
		Message msg = null;
		try {
			inputStream = new ObjectInputStream(clientSocket.getInputStream());
			msg = (Message) inputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	

	// public boolean stopClient(){
	// try{
	// inputStream.close();
	// outputStream.close();
	// clientSocket.close();
	// return true;
	// }catch(Exception e){
	// e.printStackTrace();
	// return false;
	// }
	// }
}
