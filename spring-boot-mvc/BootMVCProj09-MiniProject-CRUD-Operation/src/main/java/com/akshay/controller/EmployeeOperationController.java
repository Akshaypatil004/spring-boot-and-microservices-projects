package com.akshay.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String saveEmployee(@ModelAttribute("emp") EmployeeEntity e, RedirectAttributes attr) {
		System.out.println("EmployeeOperationController.registerEmployee()");
		
		// use service
		String registerEmployee = service.registerEmployee(e);
		
		// keep the result in the model attribute
		attr.addFlashAttribute("newEmp",registerEmployee);
		
		return "redirect:emp_report";
		
	}
	
	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@RequestParam int id, @ModelAttribute("emp") EmployeeEntity emp) {
		System.out.println("EmployeeOperationController.showEditEmployeeFormPage()");
		
		// use service 
		EmployeeEntity employeeById = service.getEmployeeById(id);
		
		//copy data
		BeanUtils.copyProperties(employeeById, emp);
		
		// return lvn
		return "update_employee";
	}
	
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attr,@ModelAttribute("emp") EmployeeEntity emp) {
		System.out.println("EmployeeOperationController.editEmployee()");
		
		// use service
		String updateEmployeeMsg = service.updateEmployee(emp);
		
		// add result to the flash attribute
		attr.addFlashAttribute("updateEmp", updateEmployeeMsg);
		
		// redirect 
		return "redirect:emp_report";
	}
	
	@GetMapping("/emp_delete")
	public String deleteEmployee(RedirectAttributes attr, @RequestParam int id) {
		System.out.println("EmployeeOperationController.deleteEmployee()");
		
		// use service
		String deletedEmpMsg = service.deleteEmployeeById(id);
		
		// keep the result in the flash attribute
		attr.addFlashAttribute("deleteEmpMsg", deletedEmpMsg);
		
		// redirect
		return "redirect:emp_report";
		
	}

}
