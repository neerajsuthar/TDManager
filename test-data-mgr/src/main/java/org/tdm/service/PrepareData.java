package org.tdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tdm.bean.TestDataBean;

public interface PrepareData {
	
	public TestDataBean createData(TestDataBean testDataBean);
	 

}
