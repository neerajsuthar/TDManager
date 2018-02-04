package org.tdm.properties;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import org.springframework.core.env.Environment;
import org.tdm.bean.Name;

@Configuration
@PropertySource("names.properties")
public class TDMProperties {
	
 @Autowired
 private Environment env;
 
@Bean
public Name getName() {
	Name name = new Name();
	
	int rand = (int) (Math.random()*50+1);
	System.out.println(rand);
	
	name.setFirstName(env.getProperty("F_NAME_"+rand));
	
	System.out.println(env.getProperty("F_NAME_"+rand));
	
	rand = (int) (Math.random()*50+1);
	System.out.println(rand);
	
	name.setLastName(env.getProperty("L_NAME_"+rand));
	
	System.out.println(env.getProperty("L_NAME_"+rand));
	
	return name;

}

}