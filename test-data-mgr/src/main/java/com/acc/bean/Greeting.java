package com.acc.bean;

public class Greeting {
	
	public Greeting() {
		// TODO Auto-generated constructor stub
	}
	
	public Greeting(String messageId,String message) {
		this.messageId=messageId;
		this.message = message;
	}
	
	private String message;
	private String messageId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}
