package com.akshay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/path")
public class PathVariableOperationController {
	
	@GetMapping("/report/{no}/{name}") 
	public ResponseEntity<String> fetchData(@PathVariable int no,@PathVariable String name){
		System.out.println("PathVariableOperationController.fetchData()");
		return new ResponseEntity<String>("No : " + no + ",Name : " + name,HttpStatus.OK);		
	}
	
	// multiple request path for the method
	@GetMapping(value={"/report1/{no}/{name}","/report1/{no}","/report1"})
	public String fetchData2(@PathVariable Integer no, @PathVariable(required = false) String name){
		System.out.println("PathVariableOperationController.fetchData2()");
		return no + " , " + name;
	}

}
