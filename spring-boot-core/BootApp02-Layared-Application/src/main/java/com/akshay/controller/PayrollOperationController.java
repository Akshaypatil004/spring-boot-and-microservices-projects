package com.akshay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.akshay.model.Employee;
import com.akshay.service.IEmployeeService;

@Controller("payroll") // make the java class spring bean cum controller 
public class PayrollOperationController {

	@Autowired
	private IEmployeeService service;
	
	public List<Employee> showAllEmployeeByDesg(String desg1, String desg2, String desg3)throws Exception{
		// user service
		return service.fetchAllEmployeeByDesg(desg1, desg2, desg3);
	}
}
