package com.akshay.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ShowHomeController {
	@Autowired
	private ServletContext ctx;
	
	@Autowired
	private ServletConfig config;
	
	@RequestMapping("/home")
	public String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/")
	public String homePage() {
		return "welcome";
	}
	
//	@RequestMapping("/process")
//	public String process(Map<String,Object> map) {
//		System.out.println("ShowHomeController.process() :: " + map.getClass());
//		// add model attribute to shared memory
//		map.put("attribute", "value");
//		map.put("date", LocalDate.now());
//		
//		return "show_data";
//	}
	
	// taking Model as return type to handler method
//	@RequestMapping("/process") // here as LVN is not return - LVN (logical view name) is request path
//	public Model process() {
//		// create shared memory
//		Model model = new BindingAwareModelMap();
//		
//		// add model attribute to shared memory
//		model.addAttribute("attribute","VALUE");
//		model.addAttribute("date",LocalDate.now());
//		
//		return model;
//	}
	
	// taking Map<K,V> as return type for hander method
//	@RequestMapping("/process") // here also LVN is request path
//	public Map<String,Object> process(){
//		System.out.println("ShowH"
//				+ "omeController.process()");
//		
//		// create shared memory
//		Map<String,Object> map = new HashMap<>();
//		
//		// add model attribute to shared memory
//		map.put("attribute", "value");
//		map.put("date", LocalDate.now());
//		
//		return map;
//	}
	
	// taking ModelAndView as return type (legacy style, spring mvc)
//	@RequestMapping("/process")
//	public ModelAndView process() {
//		System.out.println("ShowHomeController.process()");
//		
//		// create shared memory
//		ModelAndView mav = new ModelAndView();
//		
//		// add model attribute to the shared memory
//		mav.addObject("attribute","value");
//		mav.addObject("date",LocalDate.now());
//		
//		// place LVN to MAV object
//		mav.setViewName("show_data");
//		
//		return mav;
//	}
	
//	@RequestMapping("/process") // for void return type of hander method , request path is LVN
//	public void process(Map<String,Object> map) {
//		System.out.println("ShowHomeController.process()");
//		
//		// add model attribute to shared memory
//		map.put("name", "Akshay");
//		map.put("date",LocalDate.now());
//	}

	
//	@RequestMapping("/process") // for returning null on String of hander method , request path is LVN
//	public String process(Map<String,Object> map) {
//		System.out.println("ShowHomeController.process()");
//		
//		// add model attribute to shared memory
//		map.put("attribute","value");
//		map.put("name", "Akshay");
//		map.put("date",LocalDate.now());
//		
//		return null;
//	}
	
	// handler method chaining/ request forward to another handler of same controller or another controller class
//	@RequestMapping("/process")
//	public String process() {
//		System.out.println("ShowHomeController.process()");
//		return "forward:report"; // forward is fixed keyword ; report is destination/another handler request path
//		
//	}
//	@RequestMapping("/report")
//	public String showReport() {
//		System.out.println("ShowHomeController.showReport()");
//		
//		return "show_data";
//		
//	}
	// from abovethe request forward / hander chaining ; request url is not changed ,
	
	// redirect request from one handler to another handler
	
//	@RequestMapping("/process")
//	public String process(HttpServletRequest req) {
//		System.out.println("ShowHomeController.process()");
//		req.setAttribute("attribute", "value");
//		return "redirect:report"; // redirect is fix keyword : report in another handler request path
//	}
//
//	@RequestMapping("/report")
//	public String showReport(HttpServletRequest req) {
//		System.out.println("ShowHomeController.showReport()");
//		System.out.println("req attribute :: " + req.getAttribute("attr1")); // give null
//		return "show_data";
//	}
	
	// passing request , response object to handler method
	
//	@RequestMapping("/process")
//	public String process(HttpServletRequest req, HttpServletResponse res) {
//		System.out.println("ShowHomeController.process() :: " + req.hashCode());
//		req.setAttribute("name", "Akshay");
//		return "show_data";
//		
//	}
	
	// HttpSession object to handler method
//	@RequestMapping("/process")
//	public String process(HttpSession ses) {
//		System.out.println("ShowHomeController.process()");
//		ses.setAttribute("name", "Akshay");
//		return "show_data";
//	}
	
	// servletcontext, servletconfig to handler method
//	@RequestMapping("/process")
//	public String process(Map<String,Object> map) {
//		System.out.println("ShowHomeController.process()");
//		System.out.println("Web Application context path :: " + ctx.getContextPath());
//		System.out.println("DS logical name :: " + config.getServletName());
//		map.put("attribute","ServletContext,ServletConfig"); // model attribute
//		return "show_data";
//		
//	}
	
	// sending output directly to browser through handler method without involving ViewResolver
	
	@RequestMapping("/process")
	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("ShowHomeController.process()");
		
		res.setContentType("text/html");
		
		PrintWriter writer = res.getWriter();
		
		writer.println("<b> directly from handler method</b>");
		
		
	}
}
