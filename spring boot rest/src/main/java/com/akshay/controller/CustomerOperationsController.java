package com.akshay.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.model.Company;
import com.akshay.model.Customer;

@RestController
@RequestMapping("/customer") // global path
public class CustomerOperationsController {

	// api endpoints/ rest operations

	// sending objects as httpresponse body using json format
	@GetMapping("/report")
	public ResponseEntity<Customer> showCustomerReport() {

		// create customer object
		Customer cust = new Customer(101, "Akshay", 1001.00);
		// return httpresponse body
		return new ResponseEntity<Customer>(cust, HttpStatus.OK); // here httpstatus code in ok-> 200 becuase data fetch
																	// success and return
	}

	// sending complex java oject as httpresponse body using json format
	@GetMapping("/report1")
	public ResponseEntity<Customer> showCustomerReport1() {
		// create object
		Customer cust = new Customer(102, "Raja", 2001.0, new String[] { "red", "green", "blue" },
				List.of("10th", "12th", "B.tech"), Set.of(123456789L, 987456321L, 1235689L),
				Map.of("adhar", 123456, "pan", "123abc"), new Company("Samsung", "hyb", "electronic", 4000));
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust, status);
	}

	// endpoint return type as string -> text response -> default http status code
	// -> 200
	@GetMapping("/report2")
	public String showCustomerReport2() {
		return "response as text : from showCustomerReport2";

	}

	// endpoint return type as non-string -> json/xml bases accept:request header ->
	// default http status code
	// -> 200
	@GetMapping("/report3")
	public Customer showCustomerReport3() {
		return new Customer(1003, "John", 1001.0);
	}

	// endpoint return type as non-string and response entity generic -> json/xml bases accept:request header ->
	// controll over http status code
	@GetMapping("/report4")
	public ResponseEntity<Customer> showCustomerReport4() {
		return new ResponseEntity<Customer>(new Customer(1004,"Max",2001.0),HttpStatus.OK);

	}

	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer() {
		System.out.println("CustomerOperationsController.registerCustomer()");
		return new ResponseEntity<String>("From Post-registerCustomer method", HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateCustomer() {
		System.out.println("CustomerOperationsController.updateCustomer()");
		return new ResponseEntity<String>("From Put-updateCustomer method", HttpStatus.OK);
	}

	@PatchMapping("/pmodify")
	public ResponseEntity<String> updateCustomerByNo() {
		System.out.println("CustomerOperationsController.updateCustomerByNo()");
		return new ResponseEntity<String>("From Patch-updateCustomerByNo method", HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer() {
		System.out.println("CustomerOperationsController.deleteCustomer()");
		return new ResponseEntity<String>("From Delete-deleteCustomer method", HttpStatus.OK);
	}

}
