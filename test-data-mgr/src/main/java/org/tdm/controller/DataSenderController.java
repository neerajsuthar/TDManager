package org.tdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tdm.bean.Greeting;

@RestController
public class DataSenderController {
	
    @RequestMapping("/restCheck")
    public Greeting checkRestService() {
    	System.out.println("Hello");
    	Greeting greetMe = new Greeting("100","Hello Devena12");
    	greetMe.setMessage("Rest Service is available");
    	return greetMe; 
    }
    
    @RequestMapping("/checkString")
    public String checkStringtService() {
    	return "String Check Success"; 
    }
	
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting("100","Hello Devna");
    }
    
	
}
