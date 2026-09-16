package com.akshay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentOperationController {
	
	/*
	 * for request url 
	 * http://localhost:4041/request-param-app/data?sno=101&sname=akshay
	 * sno(request param name) -> no(handler param name) , sname -> name binding
	 * here request param name and handler param name are different 
	 */
//	@GetMapping("/data")
//	public String process(@RequestParam("sno") int no, @RequestParam("sname") String name) {
//		System.out.println("StudentOperationController.process()");
//		
//		System.out.println(no + " : " + name);
//		
//		return "show_result";
//	}
	
	
	/*
	 * for request url 
	 * http://localhost:4041/request-param-app/data?sno=101&sname=akshay
	 * sno -> sno , sname -> sname binding
	 * here request param name and handler param name are matching , no need mention in @RequestParam()
	 */
//	@GetMapping("/data")
//	public String process(@RequestParam int sno, @RequestParam String sname) {
//		System.out.println("StudentOperationController.process()");
//		
//		System.out.println(sno + " : " + sname);
//		
//		return "show_result";
//	}
	
	
	
	/*
	 * for request url 
	 * http://localhost:4041/request-param-app/data?sno=101&sname=akshay
	 * sno -> no , sname -> name binding
	 * here request param name and handler param name, one is matching , another is not, i.e mismatch in request param
	 * name and handler method param raises exception
	 * sno ==  sno  but sname != name -> exception (MissingServletRequestParameterException: Required request parameter 'name'
	 *  for method parameter type String is not present])
	 */
//	@GetMapping("/data")
//	public String process(@RequestParam int sno, @RequestParam String name) {
//		System.out.println("StudentOperationController.process()");
//		
//		System.out.println(sno + " : " + name);
//		
//		return "show_result";
//	}
	
	/*
	 * for request url 
	 * http://localhost:4041/request-param-app/data?sno=101&sname=akshay
	 * 
	 * here request param name and handler param name, one is matching , another is not, i.e mismatch in request param
	 * name and handler method param raises exception
	 * sno ==  sno  but sname != name -> exception (MissingServletRequestParameterException: Required request parameter 'name'
	 *  for method parameter type String is not present])
	 *  
	 *  solution 1: 
	 *  to avoid the exception though request param name and method param are different, gets default value in this case
	 *  set required value in @RequestParam as false 
	 */
//	@GetMapping("/data")
//	public String process(@RequestParam int sno, @RequestParam(required = false) String name) {
//		System.out.println("StudentOperationController.process()");
//		
//		System.out.println(sno + " : " + name);
//		
//		return "show_result";
//	}
	
	/*
	 * for request url 
	 * http://localhost:4041/request-param-app/data?sno=101&name=akshay
	 * http://localhost:4041/request-param-app/data?sno=101
	 * http://localhost:4041/request-param-app/data?sno=101&sname=akshay
	 * 
	 *  
	 *  solution 2: 
	 * use defaultValue in @RequestParam 
	 */
	@GetMapping("/data")
	public String process(@RequestParam int sno, @RequestParam(defaultValue = "raja") String name) {
		System.out.println("StudentOperationController.process()");
		
		System.out.println(sno + " : " + name);
		
		return "show_result";
	}


}
