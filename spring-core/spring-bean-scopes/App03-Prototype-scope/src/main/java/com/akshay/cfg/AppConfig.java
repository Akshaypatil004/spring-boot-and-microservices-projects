package com.akshay.cfg;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.akshay.comps")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig.AppConfig()");
	}
	
	// dependent spring bean config
	@Bean("dt")
	@Scope("prototype")
//	@Scope("singleton")
	public LocalDate createDate() {
		System.out.println("AppConfig.createDate()");
		return LocalDate.now();
	}

}
