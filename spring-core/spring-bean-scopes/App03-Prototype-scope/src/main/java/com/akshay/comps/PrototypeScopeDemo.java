package com.akshay.comps;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("proto")
@Scope("prototype")
//@Scope("singleton")
public class PrototypeScopeDemo {

	@Autowired 
	private LocalDate date; // HAS-A property
	
	public PrototypeScopeDemo() {
		System.out.println("PrototypeScopeDemo.PrototypeScopeDemo() :: 0-param constructor");
	}
	
	public void getTodaysDate(String user) {
		System.out.println("Hello," + user + " today's date is " + date.toString());
	}
}
