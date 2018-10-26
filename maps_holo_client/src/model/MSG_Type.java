package model;

import java.io.Serializable;

public enum MSG_Type implements Serializable{
	
	REQUEST_PS(0),	
	LEAVING_PS(1),	
		
	PS_INFO(2),		
	
	QUEUE_INFO(3),
	PAYMENT_INFO(4),
	UNAVAILABLE_SYS(5);
	
	private final int header;
	
	MSG_Type(int value){
		this.header = value;
	}
	
	public int getHeader(){
		return header;
	}

}
