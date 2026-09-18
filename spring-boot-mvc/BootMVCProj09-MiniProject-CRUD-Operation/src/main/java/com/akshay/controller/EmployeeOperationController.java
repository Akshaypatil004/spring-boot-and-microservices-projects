package com.akshay.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.akshay.entity.EmployeeEntity;
import com.akshay.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("EmployeeOperationController.showHomePage()");
		
		// return LVN
		return "home";
	}
	
	@GetMapping("/emp_report")
	public String showAllEmployeeReport(Map<String,Object> map) {
		System.out.println("EmployeeOperationController.showAllEmployeeReport()");
		
		// use service
		Iterable<EmployeeEntity> allEmployees = service.getAllEmployees();
		
		// add data to model attribute
		map.put("empList",allEmployees);
		
		// return LVN
		return "show_employee_report";
		
		
	}

}
