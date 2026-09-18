package com.akshay.repository;

import org.springframework.data.repository.CrudRepository;

import com.akshay.entity.EmployeeEntity;

public interface IEmployeeRepository extends CrudRepository<EmployeeEntity, Integer>{

}
