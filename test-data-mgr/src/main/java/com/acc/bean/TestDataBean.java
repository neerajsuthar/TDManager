package com.acc.bean;

import java.util.HashMap;
import java.util.List;

public class TestDataBean {
	
	private String appId;
	private String appName;
	private String dataFormat;
	private List<HashMap<String,String>> data;
	private HashMap<String,String> masked;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getDataFormat() {
		return dataFormat;
	}
	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}
	
	public List<HashMap<String, String>> getData() {
		return data;
	}
	public void setData(List<HashMap<String, String>> data) {
		this.data = data;
	}
	
	public HashMap<String, String> getMasked() {
		return masked;
	}
	public void setMasked(HashMap<String, String> masked) {
		this.masked = masked;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getAppId());
		builder.append(getAppName());
		builder.append(getDataFormat());
		builder.append(getData());
		builder.append(getMasked());
		return builder.toString();
	}
	
	

}
