package com.acc.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaskedColumn {
	
	Map<String,String> dataBean = new HashMap<String,String>();

	public Map<String, String> getDataBean() {
		return dataBean;
	}

	public void setDataBean(Map<String, String> dataBean) {
		this.dataBean = dataBean;
	}	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("--------Masked Details Starts--------");
		for(Entry<String,String> ent:getDataBean().entrySet()){
	           builder.append(ent.getKey()+" ==> "+ent.getValue());
	    }
		builder.append("--------Masked Details Starts--------");
		return builder.toString();
	}
	
}


