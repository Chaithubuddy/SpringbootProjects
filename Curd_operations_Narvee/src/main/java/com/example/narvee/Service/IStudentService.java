package com.example.narvee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.narvee.Entity.Passport;
import com.example.narvee.Entity.Student;
import com.example.narvee.Entity.pageDTO;

public interface IStudentService {

	Student saveStudent(Student student);

	Student updateStudent(Student student);

	void deleteStudent(Integer id);

	Optional<Student> getStudentById(Integer id);

	List<Student> getAllStudent();

	Page<Student> getPagination(pageDTO pagedto);

	Passport getPassportByStudentName(String name);
	
	String getNameByPId(String passportNumber);

}
