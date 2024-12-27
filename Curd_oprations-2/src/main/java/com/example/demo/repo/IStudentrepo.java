package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public interface IStudentrepo extends JpaRepository<Student, Integer> {

}
