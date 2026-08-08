// AppConfig is spring bean come configuration class 
package com.akshay.cfg;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.akshay.sbeans")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig.AppConfig()");
	}
	
	// dependent spring bean cfg
	
	@Bean("empId")
	public UUID createUUID() {
		System.out.println("AppConfig.createUUID()");
		return UUID.randomUUID();
	}
	
	@Bean("empName")
	public String createString() {
		System.out.println("AppConfig.createString()");
		return "Akshay";
	}
	
//	@Bean("empJoiningDate")
	@Bean
	public LocalDate createLocalDate() {
		System.out.println("AppConfig.createLocalDate()");
		return LocalDate.of(2026, 8, 8);
	}
	
	@Bean("empJoiningTime")
	public LocalTime createLocalTime() {
		System.out.println("AppConfig.createLocalTime()");
		return LocalTime.of(9, 30);
	}
	
	@Bean("empSalary")
	public Double createDouble() {
		System.out.println("AppConfig.createDouble()");
		return 50000D;
	}
	
	@Bean("empLastLogin")
	public LocalDateTime createLocalDateTime() {
		System.out.println("AppConfig.createLocalDateTime()");
		return LocalDateTime.now();
	}
	
}
