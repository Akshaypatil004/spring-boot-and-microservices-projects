package com.akshay.cfg;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.akshay.sbeans")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig.AppConfig()");
	}
	
	/*** 
	 * 1 target , more than 1 dependent , ambiguity problem raises 
	 * below methods are dependents but target in one create error to IOC container for dependency injection
	 */
	
	@Bean("date1")
	public LocalDate createLocalDate1() {
		return LocalDate.now();
	}
	
	@Bean("date2")
	public LocalDate createLocalDate2() {
		return LocalDate.of(2026,05,12);
	}

}
