package com.akshay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeOperationController {
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("EmployeeOperationController.showHomePage()");
		
		// return LVN
		return "home";
	}

}
