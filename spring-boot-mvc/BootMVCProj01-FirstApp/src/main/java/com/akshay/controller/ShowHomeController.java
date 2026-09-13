package com.akshay.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {
	
	@RequestMapping("/home")
	public String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/")
	public String homePage() {
		return "welcome";
	}
	
	@RequestMapping("/process")
	public String process(Map<String,Object> map) {
		System.out.println("ShowHomeController.process() :: " + map.getClass());
		// add model attribute to shared memory
		map.put("attribute", "value");
		map.put("date", LocalDate.now());
		
		return "show_data";
	}

}
