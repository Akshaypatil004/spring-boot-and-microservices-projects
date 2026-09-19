package com.akshay.service;

import com.akshay.entity.EmployeeEntity;

public interface IEmployeeMgmtService {
	
	Iterable<EmployeeEntity> getAllEmployees();
	String registerEmployee(EmployeeEntity emp);
	EmployeeEntity getEmployeeById(int id);
	String updateEmployee(EmployeeEntity emp);
	String deleteEmployeeById(int id);
}
