package com.acc.bean;

public class Response {
	
	private String message;	
	private String uuid;	
	private String statusCode;	
	private TestDataBean dataBean;
	public TestDataBean getDataBean() {
		return dataBean;
	}
	public void setDataBean(TestDataBean dataBean) {
		this.dataBean = dataBean;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
