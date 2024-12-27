package com.chaithu.narvee.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaithu.narvee.DAO.IStudentRepo;
import com.chaithu.narvee.Entity.Student;
import com.chaithu.narvee.Service.IStudentService;

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
	public Optional<Student> getStudentByid(Integer id) {
		return studentRepo.findById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

//	@Override
//	public Page<Student> createpage(PageDTO pagedto) {
//		Integer pageNumber = pagedto.getPageNumber();
//		Integer pageSize = pagedto.getPageSize();
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		return studentRepo.findAll(pageable);
//	}

}
