package com.akshay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentOperationController {
	
	@GetMapping("/report")
	public ResponseEntity<String> showReport(@RequestParam("sno") int no,@RequestParam String name){
		System.out.println("StudentOperationController.showReport()");
		// convert name to uppercase
		name = name.toUpperCase();
		// return response
		return new ResponseEntity<String>("No : " + no + ",Name : " + name,HttpStatus.OK);
	}
	@GetMapping("/report1")
	public ResponseEntity<String> showReport1(@RequestParam("sno") int no,@RequestParam(required = false, defaultValue = "name") String name){
		System.out.println("StudentOperationController.showReport()");
		// convert name to uppercase
		name = name.toUpperCase();
		// return response
		return new ResponseEntity<String>("No : " + no + ",Name : " + name,HttpStatus.OK);
	}
	
	@PostMapping("/report2")
	public ResponseEntity<String> showReport2(@RequestParam int no,@RequestParam(required = false, defaultValue = "name") String name){
		System.out.println("StudentOperationController.showReport2()");
		// convert name to uppercase
		name = name.toUpperCase();
		// return response
		return new ResponseEntity<String>("No : " + no + ",Name : " + name + " from showReport2",HttpStatus.OK);
	}

}
