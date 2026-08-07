package com.akshay.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akshay.sbeans.WishMessageGenerator;


public class App {
	public static void main(String[] args) {
		// create IOC container using ClassPathXmlApplicationContext locating spring bean configuration from build path add 
		// jar/libraries
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the target spring bean class ref - using getBean(-) method by passing bean id
		WishMessageGenerator generator = ctx.getBean("wmg",WishMessageGenerator.class);
		
		// invoke the business method
		String showWishMessage = generator.showWishMessage("Akshay");
		
		System.out.println(showWishMessage);
		
		// close the IOC container
		ctx.close();
		
		
	}

}
