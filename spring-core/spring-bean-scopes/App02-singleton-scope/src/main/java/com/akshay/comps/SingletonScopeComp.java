package com.akshay.comps;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("single")
@Scope("singleton")
public class SingletonScopeComp {
	
	@Autowired // field injection
	@Qualifier("date2")
	private LocalDate date;
	
	public SingletonScopeComp() {
		System.out.println("SingletonScopeComp.SingletonScopeComp()");
	}
	
	public void getTodaysDate(String user) {
		System.out.println("Hello, " + user + " - Todays date is :: " + date.toString());
	}

}
