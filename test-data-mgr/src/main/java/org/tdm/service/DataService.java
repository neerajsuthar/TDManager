package org.tdm.service;

import org.tdm.bean.Response;
import org.tdm.bean.TestDataBean;


public interface DataService {
	
	public Response getTestData(TestDataBean testData);
	
	public Response maskTestData(TestDataBean testData);

}
