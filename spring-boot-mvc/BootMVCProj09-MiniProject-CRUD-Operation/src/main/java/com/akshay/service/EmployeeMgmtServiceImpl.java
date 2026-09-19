package com.akshay.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.entity.EmployeeEntity;
import com.akshay.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	
	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Iterable<EmployeeEntity> getAllEmployees() {
		System.out.println("EmployeeMgmtServiceImpl.getAllEmployees()");
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(EmployeeEntity emp) {
		System.out.println("EmployeeMgmtServiceImpl.registerEmployee()");
		return "Employee is Saved with id value : " + empRepo.save(emp).getId();
	}

	@Override
	public EmployeeEntity getEmployeeById(int id) {
		System.out.println("EmployeeMgmtServiceImpl.getEmployeeById()");
		EmployeeEntity emp = empRepo.findById(id).orElseThrow(()-> new IllegalArgumentException());
		return emp;
	}

	@Override
	public String updateEmployee(EmployeeEntity emp) {
		System.out.println("EmployeeMgmtServiceImpl.updateEmployee()");
		return "Employee is updated with id value :: " + empRepo.save(emp).getId();
	}

	@Override
	public String deleteEmployeeById(int id) {
		System.out.println("EmployeeMgmtServiceImpl.deleteEmployeeById()");
		empRepo.deleteById(id);
		return id + " employee id employee is deleted";
	}
	
	

}
