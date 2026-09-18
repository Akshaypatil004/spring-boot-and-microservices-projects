package com.akshay.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/emp_add") // for form launching
	public String showFormForSaveEmployee(@ModelAttribute("emp") EmployeeEntity e) {
		System.out.println("EmployeeOperationController.showFormForSaveEmployee()");
		
		return "register_employee";
	}
	
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") EmployeeEntity e, Map<String,Object> map) {
		System.out.println("EmployeeOperationController.registerEmployee()");
		
		// use service
		String registerEmployee = service.registerEmployee(e);
		
		Iterable<EmployeeEntity> allEmployees = service.getAllEmployees();
		
		// keep the result in the model attribute
		map.put("newEmp",registerEmployee);
		map.put("empList", allEmployees);
		
		return "show_employee_report";
		
	}

}
