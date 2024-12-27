package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Student;
import com.example.demo.repo.IStudentrepo;

public interface IStudentService extends IStudentrepo{
	
	public abstract Student save(Student String);
	public abstract Student update(Student String);
	public abstract void delete(Long id);
	public abstract Student getById(Long id);
	public abstract List<Student> getAll(Student String);



}