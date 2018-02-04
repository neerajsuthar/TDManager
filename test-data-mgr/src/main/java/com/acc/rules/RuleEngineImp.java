package com.acc.rules;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.acc.bean.TestDataBean;
import com.acc.constants.ErrorCodes;
import com.acc.exceptions.Message;

@Service("dataValidator")
public class RuleEngineImp implements RuleEngine{
	
	Message message = new Message();
	
	@Override
	public Message validateSampleData(TestDataBean testDataBean) {
		System.out.println("Data validation Started");
		Map<String, String> maskMap = testDataBean.getMasked();
		
		for(HashMap<String, String> sampleMap :testDataBean.getData()) {
			int dataLine = 0;
			for(Entry<String, String> entry : sampleMap.entrySet()) {
				dataLine++;
				if(!maskMap.containsKey(entry.getKey())){
					message.setId(ErrorCodes.DATA_VALIDATION_FAILED);
					message.setMessage("Validation failed due to Column mismatch :["+maskMap+" is not available in the data line number="+dataLine+"]");
					return message;
				}
			}
		}
		message.setId(ErrorCodes.DATA_VALIDATION_SUCCESS);
		message.setMessage("Data Validation completed Successfully");
		return message;
	}

	
}
