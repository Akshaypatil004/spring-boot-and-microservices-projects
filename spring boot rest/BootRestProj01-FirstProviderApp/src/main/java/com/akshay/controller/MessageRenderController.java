package com.akshay.controller;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-api") // global path
public class MessageRenderController {
	
	@GetMapping("/wish") // request path
	public ResponseEntity<String> showMessage(){
		System.out.println("MessageRenderController.showMessage()");
		
		// get the current system time
		LocalTime time = LocalTime.now();
		
		// get the current hour 
		int hour = time.getHour();
		
		String msg = null;
		
		if(hour < 12 ) {
			msg = "Good Morning";
		}
		else if(hour < 16) {
			msg = "Good Afternoon";
		}
		else if(hour < 20) {
			msg = "Good Evening";
		}
		else {
			msg = "Good Night";
		}
		
		// create and return the response entity having response content and status code
		ResponseEntity<String> response = new ResponseEntity<String>(msg,HttpStatus.OK);
		
		return response;
	}

}
