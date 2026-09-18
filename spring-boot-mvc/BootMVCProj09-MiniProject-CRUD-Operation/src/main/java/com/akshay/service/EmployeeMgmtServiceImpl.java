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
	
	

}
