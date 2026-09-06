package com.akshay.comps;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("voter")
@PropertySource("com/akshay/commons/Info.properties")
public class CheckingVotingEligibity {
	
	@Value("${voter.id}")
	private Integer id;
	
	@Value("${voter.name}")
	private String name;
	
	@Value("${voter.age}")
	private Integer age;
	
	private LocalDate verifiedOn;
	
	
	public CheckingVotingEligibity() {
		System.out.println("CheckingVotingEligibity.CheckingVotingEligibity()");
	}
	
	// spring bean life cycle method - instantiation event - custom init life cycle method , which is automatically called by container a
	// spring bean creation and all injection completion
	@PostConstruct
	public void myInit() {
		System.out.println("CheckingVotingEligibity.myInit()");
		
		// initialize the left over properties , not participating in the injection
		this.verifiedOn = LocalDate.now();
		
		// validation logics
		if(name == null || age <= 0 ) {
			throw new IllegalArgumentException("set correct values to name, age properties");
		}
	}
	
	// business method
	
	public String checkEligibility() {
		System.out.println("CheckingVotingEligibity.checkEligibility()");
		
		if(age < 18) {
			return "Mr/Mrs/Miss. " + this.name + " you are not eligible for voting -> verified on :: " + this.verifiedOn;
		}
		else {
			return "Mr/Mrs/Miss. " + this.name + " you are eligible for voting -> verified on :: " + this.verifiedOn;
		}
	}
	
	// destroy life cycle method
	@PreDestroy
	public void myDestroy() {
		System.out.println("CheckingVotingEligibity.myDestroy()");
		
		// nullification of bean properties
		this.name = null;
		this.age = null;
		this.verifiedOn = null;
		this.id = null;
		
	}

}
