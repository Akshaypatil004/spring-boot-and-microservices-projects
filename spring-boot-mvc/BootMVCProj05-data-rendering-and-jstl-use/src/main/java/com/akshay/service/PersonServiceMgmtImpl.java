package com.akshay.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceMgmtImpl implements IPersonServiceMgmt {

	@Override
	public String showWishMessage() {
		System.out.println("PersonServiceMgmtImpl.showWishMessage()");
		
		// get the current time of the day
		LocalTime time = LocalTime.now();
		
		// get current hour 
		int hour = time.getHour();
		
		// show message
		if(hour < 12) {
			return "Good Morning";
		}
		else if(hour <=17) {
			return "Good Afternoon";
		}
		else if(hour <=21) {
			return "Good Evening";
		}
		else {
			return "Good Night";
		}
	}

}
