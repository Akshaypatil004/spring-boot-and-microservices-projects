package com.akshay.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.model.Address;
import com.akshay.model.Student;

@RestController
@RequestMapping("/student")
public class StudentOperationController {
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Student student){
		System.out.println("StudentOperationController.register()");
		
		// send response 
		return new ResponseEntity<String>("Student register successfully ! Id :: " + student.getId(), HttpStatus.CREATED);
	}
	
	@GetMapping("/show")
	public ResponseEntity<Student> showStudent(){
		System.out.println("StudentOperationController.showStudent()");
		// send response
		return new ResponseEntity<Student>(
				new Student("Akshay",
				Map.of("Java",90,"SQL",80,"Web",80),
				Set.of(123456789L,789456123L,741852963L),
				List.of("Ak","Akki"),
				new Address("Pune",123456)),
				HttpStatus.OK		
		);
	}

}
