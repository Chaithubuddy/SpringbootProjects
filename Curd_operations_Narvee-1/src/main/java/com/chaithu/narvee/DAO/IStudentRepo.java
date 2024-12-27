package com.chaithu.narvee.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaithu.narvee.Entity.Passport;
import com.chaithu.narvee.Entity.Student;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer>{
	
	
	//Passport passportByStudentName(Student student);

}
