package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.SortDTO;
import com.example.demo.Entity.Student;
import com.example.demo.Service.IStudentService;
import com.example.demo.repo.IStudentrepo;

@Service
public class StudentImpl implements IStudentService {
	
	@Autowired
	private IStudentrepo studentrepo;

	@Override
	public Student saveStudent(Student student) {
		return	studentrepo.save(student);
	}
	

	@Override
	public Student updateStudent(Student student) {
		return	studentrepo.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentrepo.deleteById(id);
	}

	@Override
	public Optional<Student> getStudentById(Integer id) {
		 return studentrepo.findById(id);
	}


	@Override
	public List<Student> getAllStudent(Pageable pageable) {
		return (List<Student>) studentrepo.findAll(pageable);
	}


	@Override
	public Page<Student> getall(SortDTO sortdto) {
		Integer pagenumber = sortdto.getPageNumber();
		 Integer pagesize =  sortdto.getPageSize();
		 Pageable pageable = PageRequest.of(pagenumber, pagesize); 
		return studentrepo.findAll(pageable);
	}


	
	
	
	



}
