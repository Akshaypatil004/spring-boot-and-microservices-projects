package com.akshay.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
	private Integer id;
	private String name;
	private Double billAmt;
	private String[] favColors;
	private List<String> studies;
	private Set<Long> phoneNumbers;
	private Map<String,Object> idDetails;
	private Company company; // HAS-property
	
	public Customer(Integer id,String name,Double billAmt) {
		this.id = id;
		this.name = name;
		this.billAmt = billAmt;
	}

	public Customer(int id, String name, double billAmt, String[] favColors, List<String> studies, Set<Long> phoneNumbers,
			Map<String, Object> idDetails, Company company) {
		this.id = id;
		this.name = name;
		this.billAmt = billAmt;
		this.favColors = favColors;
		this.studies = studies;
		this.phoneNumbers = phoneNumbers;
		this.idDetails = idDetails;
		this.company = company;
	}

	
	
	
}
