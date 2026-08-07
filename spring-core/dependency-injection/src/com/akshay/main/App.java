package com.akshay.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.akshay.sbeans.WishMessageGenerator;


public class App {
	public static void main(String[] args) {
		// create IOC container using FileSystemXmlApplicationContext by passing location of spring bean configuration
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/akshay/cfg/applicationContext.xml");
		
		// get the target spring bean class ref - using getBean(-) method by passing bean id 
		Object obj = ctx.getBean("wmg");
		
		// type casting
		WishMessageGenerator generator = (WishMessageGenerator)obj;
		
		// invoke the business method
		String showWishMessage = generator.showWishMessage("Akshay");
		
		System.out.println(showWishMessage);
		
		// close the IOC container
		ctx.close();
		
		
	}

}
