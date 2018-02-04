package org.tdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.tdm.bean.Greeting;
import org.tdm.bean.Response;
import org.tdm.bean.TestDataBean;
import org.tdm.exceptions.Message;
import org.tdm.service.DataService;

@RestController
public class DataController {

	@Autowired
	DataService dataService;
	
	@RequestMapping(value = "/generateData", method = RequestMethod.POST)
	public Response createUser(@RequestBody TestDataBean testBean, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User : {}"+testBean);
		Response response = dataService.getTestData(testBean);
		return response;
	}
	
	@RequestMapping(value = "/maskData", method = RequestMethod.POST)
	public Response maskUser(@RequestBody TestDataBean testBean, UriComponentsBuilder ucBuilder) {
		System.out.println("Masking User : {}"+testBean);
		Response response = dataService.maskTestData(testBean);
		return response;
	}
	
}
