package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.SortDTO;
import com.example.demo.Entity.Student;

public interface IStudentService {
	
	public abstract Student saveStudent(Student student);
	public abstract Student updateStudent(Student student);
	public abstract void deleteStudent(Integer id);
	public abstract Optional<Student> getStudentById(Integer id);
	public abstract List<Student> getAllStudent(Pageable pageable);
	
	
	public Page<Student> getall(SortDTO sortdto);



}