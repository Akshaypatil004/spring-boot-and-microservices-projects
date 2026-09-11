package com.akshay.service;

import java.util.List;

import com.akshay.model.Employee;

public interface IEmployeeService {
	
	List<Employee> fetchAllEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception;

	int addEmployee(Employee emp) throws Exception;
}
