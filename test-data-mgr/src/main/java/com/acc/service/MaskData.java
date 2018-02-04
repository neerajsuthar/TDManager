package com.acc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.acc.bean.MaskedColumn;
import com.acc.bean.TestDataBean;

public interface MaskData {
	
	public TestDataBean maskData(TestDataBean testDataBean) throws Exception;
	 

}
