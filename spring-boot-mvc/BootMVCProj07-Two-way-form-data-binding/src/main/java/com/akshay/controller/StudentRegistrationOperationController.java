package com.akshay.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.model.Student;

@Controller
public class StudentRegistrationOperationController {
	
	@GetMapping("/")
	public String homePage() {
		System.out.println("StudentRegistrationOperationController.homePage()");
		// return LVN
		return "home";
	}
	
	// for lunching form page
	@GetMapping("/register")
	public String showForm(@ModelAttribute("stud") Student st) {
		System.out.println("StudentRegistrationOperationController.showForm()");
		System.out.println("Model class object data :: " + st);
		
		return "student_register";
	}
	
	// for form submission operation
	
	@PostMapping("/register")
	public String processStudent(Map<String,Object> map,@ModelAttribute("stud") Student st) {
		System.out.println("StudentRegistrationOperationController.processStudent()");
		System.out.println("Model class object data :: " + st);
		
		// generate the result
		String grade = null;
		if(st.getAvg() >= 75) {
			grade = "First Class with Dist";
		}
		else if(st.getAvg() >=60) {
			grade = "First Class";
		}
		else if(st.getAvg() >=50) {
			grade = "Second class";
		}
		else if(st.getAvg() >=35) {
			grade = "Third Class";
		}
		else {
			grade = "Fail";
		}
		
		// keep the result in the model attribute
		
		map.put("result", grade);
		
		// return LVN
		return "show_result";
	}

}
