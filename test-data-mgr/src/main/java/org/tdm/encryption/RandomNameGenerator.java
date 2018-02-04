package org.tdm.encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.tdm.properties.TDMProperties;

public class RandomNameGenerator {

	@Autowired
	private TDMProperties properties;
	
	public String genarateFirstName() {
		return properties.getName().getFirstName();
	}
	
	public String genarateLastName() {
		return properties.getName().getLastName();
	}

}
