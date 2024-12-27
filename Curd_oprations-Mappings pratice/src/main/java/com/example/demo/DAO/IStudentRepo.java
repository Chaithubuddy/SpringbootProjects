package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Student;

public interface IStudentRepo  extends JpaRepository<Student, Integer>{

}
