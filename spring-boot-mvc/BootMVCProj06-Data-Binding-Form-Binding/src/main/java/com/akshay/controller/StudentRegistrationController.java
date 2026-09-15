package com.akshay.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.model.Student;

@Controller
public class StudentRegistrationController {
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("StudentRegistrationController.homePage()");
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationPage() {
		System.out.println("StudentRegistrationController.showRegistrationPage()");
		return "student_register";
	}
	
	@PostMapping("/register")
	public String registerStudent(Map<String,Object> map, @ModelAttribute Student st) {
		System.out.println("StudentRegistrationController.registerStudent()");
		
		System.out.println(st);
		
		return "show_result";
	}

}
