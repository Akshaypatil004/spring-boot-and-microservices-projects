package com.akshay.comps;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("flipkart")
public class Flipkart {
	
	@Autowired
//	@Qualifier("${courier.id}") -> invalid
//	@Qualifier(@Value("${courier.id}"))  -> invalid
	
	/*@Value("${courier.id}")
	private String beanId; -> invalid
	@Qualifier("beanId")*/ 
	
	@Qualifier("shipment") // valid -> alias name , bean id will be collected from properties file
						   // in spring bean cfg file configurea and for that bean id fix alias name
						   // is used , we can different dependent spring bean from properties file
						   // directly without touching the source of target spring achieving 100% loose
						   // coupling while solving ambiguity problem 
	private ICourier courier;
	
	public Flipkart() {
		System.out.println("Flipkart.Flipkart()");
	}
	
	public String shopping(String items[],double prices[]) {
		System.out.println("Flipkart.shopping()");
		
		// calculate bill amount
		double billAmt = 0.0;
		for(double amt : prices) {
			billAmt += amt;
		}
		
		// generate Order id randomly
		int oid = new Random().nextInt(100000);
		
		// deliever the order using courier
		String msg = courier.deliver(oid);
		
		return Arrays.toString(items) + " are shipped having bill amount :: " + billAmt + "--->" + msg;
		
	}

}
