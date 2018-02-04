package org.tdm.rules;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.tdm.bean.TestDataBean;
import org.tdm.exceptions.Message;

public interface RuleEngine {
	
	public Message validateSampleData(TestDataBean testDataBean);

}
