package com.akshay.comps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {

	@Autowired
	private IEngine engine;
	
	public Vehicle() {
		System.out.println("Vehicle.Vehicle()");
	}
	
	// b.method
	public void journey(String startPlace, String destPlace) {
		System.out.println("Vehicle.journey()");
		
		engine.startEngine();
		
		System.out.println("Journey is going on from " + startPlace + " to " + destPlace + "---");
		
		try {
			Thread.sleep(40000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Journey stop at : " + destPlace);
		engine.stopEngine();
	}
	
	
}
