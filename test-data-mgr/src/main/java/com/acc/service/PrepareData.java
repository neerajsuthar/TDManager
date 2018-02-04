package com.acc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.acc.bean.TestDataBean;

public interface PrepareData {
	
	public TestDataBean createData(TestDataBean testDataBean);
	 

}
