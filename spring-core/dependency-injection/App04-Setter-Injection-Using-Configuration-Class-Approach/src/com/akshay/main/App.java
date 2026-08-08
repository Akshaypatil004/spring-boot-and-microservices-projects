package com.akshay.main;


import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.cfg.AppConfig;
import com.akshay.sbeans.Employee;

public class App {
	public static void main(String[] args) {
		// create IOC container by passing configurable class as input
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		try(ctx){
			// get target spring bean and display it details
			Employee emp = ctx.getBean("employee",Employee.class);
			
			System.out.println(emp);
			
			System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
