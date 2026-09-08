package com.akshay.comps;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("seasonFinder")
public class SeasonFinder {
	
	@Autowired
	private LocalDate date;

	public SeasonFinder() {
		System.out.println("SeasonFinder.SeasonFinder()");
	}
	
	// b. method
	
	public String findSeason() {
		// get the corrent month value
		int month = date.getMonthValue();
		
		// show season name
		if(month >= 3 && month <=6) {
			return "Summer season";
		}
		else if(month >=7 && month<=10) {
			return "Rainy Season";
		}
		else {
			return "Winter season";
		}
	}
}
