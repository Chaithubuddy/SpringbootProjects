package com.example.narvee.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.narvee.Dao.IStudentRepo;
import com.example.narvee.Entity.Passport;
import com.example.narvee.Entity.Student;
import com.example.narvee.Entity.pageDTO;
import com.example.narvee.Service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentRepo studentRepo;

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepo.deleteById(id);

	}

	@Override
	public Optional<Student> getStudentById(Integer id) {
		return studentRepo.findById(id);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public Page<Student> getPagination(pageDTO pagedto) {

		Integer pageNumber = pagedto.getPageNumber();
		Integer pageSize = pagedto.getPageSize();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return studentRepo.findAll(pageable);

	}

	 public Passport getPassportByStudentName(String name) {
	        return studentRepo.getPassportByStudentName(name);
	    }

	@Override
	public String getNameByPId(String passportNumber) {
		return studentRepo.getStudentNameByPassportNumber(passportNumber);
	}

	


	

	
	}


