package com.example.demo.ServiceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.IStudentRepo;
import com.example.demo.Entity.Student;
import com.example.demo.Service.IStudentService;

@Service
public class StudentServiceIMPL implements IStudentService {

	@Autowired
	private IStudentRepo repo;

	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<Student> getAllStudent(Pageable pageable) {
		return repo.findAll();

	}

	@Override
	public Optional<Student> getByIdStudent(Integer id) {
		return repo.findById(id);
	}

}
