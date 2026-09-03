package com.akshay.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ambiguity")
public class AmbiguityProblem {
	
	@Autowired // field injection
	private LocalDate date;

	public AmbiguityProblem() {
		System.out.println("AmbiguityProblem.AmbiguityProblem()");
	}

	@Override
	public String toString() {
		return "AmbiguityProblem [date=" + date + "]";
	}
	
}
