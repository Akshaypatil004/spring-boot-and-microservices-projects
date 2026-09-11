package com.akshay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.akshay.dao.IEmployeeDAO;
import com.akshay.model.Employee;

@Service("empService") // to make java class as spring bean cum service class
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public List<Employee> fetchAllEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeServiceImpl.fetchAllEmployeeByDesg()");
		
		// convert desg to uppercase
		desg1 = desg1.toUpperCase();
		desg2 = desg2.toUpperCase();
		desg3 = desg3.toUpperCase();
		
		// use dao 
		List<Employee> listEmp = dao.getEmployeesByDesg(desg1, desg2, desg3);
		
		// calculate gross and net salary
		// assuming DA = 10%, Allowance= 5% , PF = 5%, TAX = 5%
		listEmp.forEach(emp->{
			double salary = emp.getSalary();
			double da = salary * 0.1;
			double allowance = salary * 0.05;
			double pf = salary * 0.05;
			double tax = salary * 0.05;
			
			double grossSalary = salary + da + allowance;
			double netSalary = grossSalary - pf - tax;
			
			emp.setGrossSalary(grossSalary);
			emp.setNetSalary(netSalary);
		});
		
		return listEmp;
	}

	@Override
	public int addEmployee(Employee emp) throws Exception {
		System.out.println("EmployeeServiceImpl.addEmployee()");
		// use dao
		return dao.insertEmployee(emp);
	}

}
