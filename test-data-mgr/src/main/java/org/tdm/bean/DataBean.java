package org.tdm.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class DataBean {
	
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
		builder.append("--------DataBean Details Starts--------");
		Map<String,String> test = getDataBean();
		for(Entry<String,String> ent:test.entrySet()){
	           builder.append(ent.getKey()+" ==> "+ent.getValue());
	    }
		builder.append("--------DataBEan Details Starts--------");
		return builder.toString();
	}
	
	

}
