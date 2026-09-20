package com.akshay.service;

import java.util.List;

import com.akshay.entity.Student;

public interface IStudentMgmtService {
	List<Student> showAllStudent();
	String addStudent(Student stud);
}
