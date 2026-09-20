package com.akshay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.entity.Student;
import com.akshay.repository.IStudentRepo;

@Service
public class StudentServiceMgmtImpl implements IStudentMgmtService{

	@Autowired
	private IStudentRepo repo;
	
	@Override
	public List<Student> showAllStudent() {
		System.out.println("StudentServiceMgmtImpl.showAllStudent()");
		return repo.findAll();
	}

	@Override
	public String addStudent(Student stud) {
		System.out.println("StudentServiceMgmtImpl.addStudent()");
		
		return "Student is addedd successfully , Roll No : " + repo.save(stud).getRollNo();
	}

}
