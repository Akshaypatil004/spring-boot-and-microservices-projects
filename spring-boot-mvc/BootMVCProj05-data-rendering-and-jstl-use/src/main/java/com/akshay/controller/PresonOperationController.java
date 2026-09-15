package com.akshay.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.akshay.model.Person;
import com.akshay.service.IPersonServiceMgmt;

@Controller
public class PresonOperationController {
	
	@Autowired
	private IPersonServiceMgmt service;
	
	@GetMapping("/")
//	@GetMapping -> this is also valid , if no request path mention default is '/' 
	public String homePage() {
		System.out.println("PresonOperationController.homePage()");
		return "home";
	}
	
	@GetMapping("/wish-message")
	public String wishMessage(Map<String,Object> map) {
		System.out.println("PresonOperationController.wishMessage()");
		
		// use service 
		String msg = service.showWishMessage();
		
		// add data/value to model attribute
		map.put("msg",msg);
		
		// passing simple values to view component through model attribute
		map.put("heroName", "Thalapathy Vijay");
		map.put("nickName","parthiban");
		map.put("movieName","Leo");
		map.put("budget", 3000000000L);
		
		// passing array, collection to view component through model attribute
		map.put("arrAnimal",new String[] {"Lion","Tiger","Horse","Wolf"});
		map.put("listOfFruits", List.of("Apple","Banana","Mango","Grapes","Guava"));
		map.put("setOfNumbers",Set.of(1234567890L,987654321L,9999999999L));
		map.put("mapOfID",Map.of("aadhar",123456789L,"pan","123abc"));
		
		// passing model/class object to view component through model attribute
		Person person = new Person(1001,"Akshay","Hydrabad");
		map.put("person", person);
		
		// passing collection/list of model to to view component through model attribute
		Person p1 = new Person(2001,"Shubham","Pune"); 
		Person p2 = new Person(2002,"Yash","Pune"); 
		Person p3 = new Person(2003,"PJ","Pune"); 
		List<Person> listOfPerson = List.of(p1,p2,p3);
		map.put("listOfPerson",listOfPerson);
		
		// return LVN
		return "display";
	}
	
	

}
