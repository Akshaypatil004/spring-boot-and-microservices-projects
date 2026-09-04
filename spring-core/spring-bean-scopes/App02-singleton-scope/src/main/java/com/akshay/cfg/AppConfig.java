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
	
	// dependents pre-defined spring bean config
	
	@Bean("date1")
	@Scope("singleton")
	public LocalDate createDate1() {
		return LocalDate.of(2025, 10, 28);
	}
	

	@Bean("date2")
	@Scope("singleton")
	public LocalDate createDate2() {
		return LocalDate.now();
	}

}
