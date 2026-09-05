package com.akshay.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.akshay.comps.Printer;

@Configuration
@ComponentScan(basePackages = "com.akshay.comps")
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig.AppConfig()");
	}
	
	@Bean("printer")
	@Scope("prototype")
	public Printer getPrinter() {
		System.out.println("AppConfig.getPrinter()");
		return Printer.getInstance();
	}
}
