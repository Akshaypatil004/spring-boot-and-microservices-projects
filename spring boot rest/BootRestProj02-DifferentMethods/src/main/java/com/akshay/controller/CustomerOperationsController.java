package com.akshay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer") // global path
public class CustomerOperationsController {
	
	// api endpoints/ rest operations
	@GetMapping("/report")
	public ResponseEntity<String> showCustomerReport(){
		System.out.println("CustomerOperationsController.showCustomerReport()");
		return new ResponseEntity<String>("From Get-ShowReport method",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(){
		System.out.println("CustomerOperationsController.registerCustomer()");
		return new ResponseEntity<String>("From Post-registerCustomer method",HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateCustomer(){
		System.out.println("CustomerOperationsController.updateCustomer()");
		return new ResponseEntity<String>("From Put-updateCustomer method",HttpStatus.OK);
	}
	
	@PatchMapping("/pmodify")
	public ResponseEntity<String> updateCustomerByNo(){
		System.out.println("CustomerOperationsController.updateCustomerByNo()");
		return new ResponseEntity<String>("From Patch-updateCustomerByNo method",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(){
		System.out.println("CustomerOperationsController.deleteCustomer()");
		return new ResponseEntity<String>("From Delete-deleteCustomer method",HttpStatus.OK);
	}

}
