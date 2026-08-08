// employee class having some detail , no business method , 
// demonstrate setter injection and toString method to display employee details

package com.akshay.sbeans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("emp")
@Component
public class Employee {
	// all properties are pre-defined HAS-A properties
	private UUID empId;
	private String name;
	private LocalDate joiningDate;
	private LocalTime joiningTime;
	private Double salary;
	private LocalDateTime lastLogin;
	
	public Employee() {
		System.out.println("Employee.Employee()");
	}

	// setter method for setter injection
	@Autowired
	public void setEmpId(UUID empId) {
		this.empId = empId;
	}

	@Autowired
	public void setName(String name) {
		this.name = name;
	}

	@Autowired
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Autowired
	public void setJoiningTime(LocalTime joiningTime) {
		this.joiningTime = joiningTime;
	}

	@Autowired
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Autowired
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	// toString method to display employee details
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", joiningDate=" + joiningDate + ", joiningTime="
				+ joiningTime + ", salary=" + salary + ", lastLogin=" + lastLogin + "]";
	}	
	
}
