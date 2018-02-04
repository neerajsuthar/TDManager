package org.tdm.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tdm.bean.Response;
import org.tdm.bean.TestDataBean;
import org.tdm.constants.ErrorCodes;
import org.tdm.exceptions.Message;
import org.tdm.rules.RuleEngine;


@Service
public class DataServiceImp implements DataService{

	@Autowired
	@Resource(name="dataValidator")
	RuleEngine ruleEngine;

	@Autowired
	@Resource(name="prepareData")
	PrepareData prepareData;
	
	@Autowired
	@Resource(name="maskData")
	MaskData maskData;

	@Override
	public Response getTestData(TestDataBean testData) {

		Response response = new Response();
		Message message = ruleEngine.validateSampleData(testData);

		if(message.getId().equals(ErrorCodes.DATA_VALIDATION_SUCCESS)) {
			TestDataBean tBean = prepareData.createData(testData);
			response.setDataBean(tBean);
		}
		response.setMessage(message.getMessage());
		response.setStatusCode(message.getId()+"");
		return response;
	}

	public Response maskTestData(TestDataBean testData) {

		Response response = new Response();
		Message message = ruleEngine.validateSampleData(testData);

		if(message.getId().equals(ErrorCodes.DATA_VALIDATION_SUCCESS)) {
			TestDataBean tBean = null;
			try {
				tBean = maskData.maskData(testData);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setDataBean(tBean);
		}
		response.setMessage(message.getMessage());
		response.setStatusCode(message.getId()+"");
		return response;
	}


}
