package com.akshay.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class SeasonFinderMgmtServiceImpl implements SeasonFinderMgmtService {

	@Override
	public String findSeason() {
		System.out.println("SeasonFinderMgmtServiceImpl.findSeason()");
		
		// get the system date
		LocalDate date = LocalDate.now();
		
		// get the current month of the year
		int month = date.getMonthValue();
		
		// generate the season
		if(month >=3 && month <=6) {
			return "Summer Season";
		}
		else if(month >=7 && month <=9) {
			return "Rainy Season";
		}
		else {
			return "Winter Season";
		}
	}

}
