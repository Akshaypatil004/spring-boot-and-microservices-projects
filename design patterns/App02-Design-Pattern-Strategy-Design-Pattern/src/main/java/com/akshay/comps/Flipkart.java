package com.akshay.comps;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("flipkart")
public class Flipkart {
	
	@Autowired
	@Qualifier("blueDart")
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
