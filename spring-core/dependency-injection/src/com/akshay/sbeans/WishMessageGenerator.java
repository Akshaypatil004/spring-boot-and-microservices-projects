package com.akshay.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;


public class WishMessageGenerator {
	
	// HAS-Property 
	private LocalTime time;
	private LocalDate date;
	private String email;
	//normal properties
	private int age;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator :: no-arg constructor");
	}
	
	// setter methods for setter injections
	
	public void setTime(LocalTime time) {
		System.out.println("WishMessageGenerator.setTime()");
		this.time = time;
	}

	public void setDate(LocalDate date) {
		System.out.println("WishMessageGenerator.setDate()");
		this.date = date;
	}

	public void setEmail(String email) {
		System.out.println("WishMessageGenerator.setEmail()");
		this.email = email;
	}

	public void setAge(int age) {
		System.out.println("WishMessageGenerator.setAge()");
		this.age = age;
	}
	
	// business method - greet user based on time
	public String showWishMessage(String user) {
		System.out.println("WishMessageGenerator.showWishMessage()");
		
		// get the current hour of the day
		int hour = time.getHour();
		
		// generate the wish message
		if(hour < 12) {
			return "Good Morning :: " + user + "\nAge :: " + this.age + "\nEmail :: " + email + "\nDate :: " + date.toString();
		}
		else if(hour <16) {
			return "Good Afternoon :: " + user + "\nAge :: " + this.age + "\nEmail :: " + email + "\nDate :: " + date.toString();
		}
		else if(hour <20) {
			return "Good Evening :: " + user + "\nAge :: " + this.age + "\nEmail :: " + email + "\nDate :: " + date.toString();
		}
		else {
			return "Good Night :: " + user + "\nAge :: " + this.age + "\nEmail :: " + email + "\nDate :: " + date.toString();
		}
	}

	
	
	
}
