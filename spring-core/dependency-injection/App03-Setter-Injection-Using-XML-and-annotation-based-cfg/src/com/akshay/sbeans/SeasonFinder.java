package com.akshay.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf") // sf is bean id
public class SeasonFinder {
	// HAS-A property
	private LocalDate date;
	
	public SeasonFinder() {
		System.out.println("SeasonFinder.SeasonFinder()");
	}
	
	// setter method for setter injection
	
	// @Autiwired place on setter method perform setter injection
	// by identifying dependent spring bean property type and name
	@Autowired 
	public void setDate(LocalDate date) {
		System.out.println("SeasonFinder.setDate()");
		
		this.date  = date;
	}
	
	// business method
	public String showSeasonName() {
		System.out.println("SeasonFinder.showSeasonName()");
		
		// get current month value
		int month = date.getMonthValue();
		if(month >=3 && month<=6) {
			return "Summer season";
		}
		else if(month >=7 && month <=9) {
			return "Rainy Season";
		}
		else {
			return "Winter season";
		}
	}
	

}
