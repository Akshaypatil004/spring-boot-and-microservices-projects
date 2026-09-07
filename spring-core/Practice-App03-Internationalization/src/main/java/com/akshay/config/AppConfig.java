package com.akshay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
	
	
	@Bean("messageSource") // fixed bean id , -> container automatically called getBean() method using this bean id to activate 
						   // specific properties file based on Locale object data
	public ResourceBundleMessageSource createRBMS() {
		ResourceBundleMessageSource msg = new ResourceBundleMessageSource();
		
		// configure / set base properties 
		msg.setBasename("com/akshay/commons/App");
		
		return msg;
		
	}

}
