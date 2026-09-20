package com.akshay.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.akshay.entity.Student;
import com.akshay.service.IStudentMgmtService;

@Controller
@RequestMapping("/student")
public class StudentOperationController {
	
	@Autowired
	private IStudentMgmtService service;
	
	@GetMapping("/")
	public String homePage() {
		System.out.println("StudentOperationController.homePage()");
		return "index";
	}
	
	@GetMapping("/show-all-students")
	public String showAllStudent(Map<String,Object> map) {
		System.out.println("StudentOperationController.showAllStudent()");
		
		// use service
		List<Student> showAllStudent = service.showAllStudent();
		
		// keep the data in model attribute
		map.put("students", showAllStudent);
		
		// return LVN
		return "student-list-page";
	}
	
	@GetMapping("/add-student")
	public String showAddStudentForm() {
		System.out.println("StudentOperationController.showAddStudentForm()");
		return "add-student-page";
	}
	
	@PostMapping("/add-student")
	public String addStudent(@ModelAttribute Student stud, RedirectAttributes attr) {
		System.out.println("StudentOperationController.addStudent()");
		
		// use service
		String studentMsg = service.addStudent(stud);
		
		// keep data to the redirect scope flash attribute
		attr.addFlashAttribute("resultMsg",studentMsg);
		
		return "redirect:show-all-students";
	}

}
