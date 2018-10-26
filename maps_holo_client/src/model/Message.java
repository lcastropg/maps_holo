package model;

import java.io.Serializable;

public class Message implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 2967745113692183320L;
	private MSG_Type header;
	private Object content;
	
	public Message(MSG_Type header, Object content) {		
		this.header = header;
		this.content = content;
	}
	
	public Message(MSG_Type header) {
		this.header = header;
		content = new Object();
	}
	
	public MSG_Type getHeader() {
		return header;
	}
	
	public void setHeader(MSG_Type header) {
		this.header = header;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	
	

}
