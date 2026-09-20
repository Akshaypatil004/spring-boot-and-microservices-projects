package com.akshay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.entity.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
