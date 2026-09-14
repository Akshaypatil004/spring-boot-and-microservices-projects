package com.akshay.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.akshay.model.Customer;
import com.akshay.service.SeasonFinderMgmtService;

@Controller
public class SeasonOperationController {
	
	@Autowired
	private SeasonFinderMgmtService service;
	
	@GetMapping("/")
	public String homePage() {
		System.out.println("SeasonOperationController.homePage()");
		return "home";
	}
	
	@GetMapping("/season")
	public String showSeason(Map<String,Object> map) {
		System.out.println("SeasonOperationController.showSeason()");
		
		// use service 
		String season = service.findSeason();
		
		// keep the result in the model attribute
		map.put("season", season);
		
		// different values/data pass using data rendering from controller to view component
		
		// simple value passing - model attribute
		map.put("name","Akshay");
		map.put("age", 23);
		map.put("address", "Hydrabad");
		
		// passing arrays , collection values as model atrribute
		map.put("arrNickNames", new String[] {"Akshay","Akki"});
		map.put("listOfFriends", List.of("Akshay","Shubham","Yash"));
		map.put("setOfPhonenumbers", Set.of(8888888888L,999999999L));
		map.put("mapOfIdDetails",Map.of("aadhar",645245L,"voterId",464672L));
		
		// passing model clas as model attribute
		Customer cust = new Customer(1001,"Akshay","Hyb",8529.0f);
		map.put("custData",cust);
		
		// passing list of model class as model attribute
		Customer c1 = new Customer(100,"Mahesh","Vizag",7894.0f);
		Customer c2 = new Customer(101,"Rajesh","Kochi",794.0f);
		Customer c3 = new Customer(102,"Suresh","Hydrabad",894.0f);
		List<Customer> listOfCustomer = List.of(c1,c2,c3);
		
		map.put("listCustData",listOfCustomer);
		
		// return LVN
		return "display";
	}

}
