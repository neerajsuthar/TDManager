package com.acc.rules;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.acc.bean.TestDataBean;
import com.acc.exceptions.Message;

public interface RuleEngine {
	
	public Message validateSampleData(TestDataBean testDataBean);

}
