package com.akshay.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.akshay.service.SeasonService;

@Controller
public class SeasonOperationController {
	
	@Autowired
	private SeasonService service;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("SeasonOperationController.home()");
		return "welcome";
	}
	
	@RequestMapping("/season")
	public String getSeason(Map<String,Object> map) {
		System.out.println("SeasonOperationController.getSeason()");
		
		// use service
		String resultMsg = service.findSeason();
		
		// add result to model attribute
		map.put("season", resultMsg);
		
		return "display";
	}

}
