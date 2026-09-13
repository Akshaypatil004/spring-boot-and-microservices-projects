package com.akshay.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class SeasonService {
	
	
	public String findSeason() {
		System.out.println("SeasonService.findSeason()");
		
		// get the system date
		LocalDate date = LocalDate.now();
		
		// get the current month
		int month = date.getMonthValue();
		
		// find season
		if(month >=7 && month <=9) {
			return "Rainy Season";
		}
		else if(month >=3 && month <=6) {
			return "Summer Season";
		}
		else {
			return "Winter Season";
		}
		
	}

}
