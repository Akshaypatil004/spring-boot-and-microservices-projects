package com.akshay.main;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akshay.sbeans.SeasonFinder;

public class App {
	
	public static void main(String[] args) {
		// create IOC container
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")){
			
			// get the target spring bean class obect ref
			SeasonFinder season = ctx.getBean("sf",SeasonFinder.class);
			
			// invoke the business method
			String msg = season.showSeasonName();
			System.out.println(msg);
			System.out.println("======================");
			
			System.out.println("Spring beans count :: " + ctx.getBeanDefinitionCount());
			System.out.println("Spring bean defination names/id's ::" + Arrays.toString(ctx.getBeanDefinitionNames()));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
