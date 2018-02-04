package org.tdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.tdm.encryption.RandomNameGenerator;
import org.tdm.properties.TDMProperties;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
public class TestMaskToolApplication {

	public static void main(String[] args) {
		
		ApplicationContext ct = new AnnotationConfigApplicationContext(TDMProperties.class);
		
		/*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
			 ctx.register(TDMProperties.class);
			 ctx.refresh(); */
			 
		SpringApplication.run(TestMaskToolApplication.class, args);
		
		 RandomNameGenerator gen = new RandomNameGenerator();
		 System.out.println(gen.genarateFirstName() + " " + gen.genarateLastName());
		
		
		
	}
	
	
}
