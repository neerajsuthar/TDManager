package org.tdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tdm.bean.MaskedColumn;
import org.tdm.bean.TestDataBean;

public interface MaskData {
	
	public TestDataBean maskData(TestDataBean testDataBean) throws Exception;
	 

}
