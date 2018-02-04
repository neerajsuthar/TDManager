package com.acc.service;

import com.acc.bean.Response;
import com.acc.bean.TestDataBean;


public interface DataService {
	
	public Response getTestData(TestDataBean testData);
	
	public Response maskTestData(TestDataBean testData);

}
