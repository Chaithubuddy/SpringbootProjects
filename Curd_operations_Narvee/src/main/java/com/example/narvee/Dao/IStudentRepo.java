package com.example.narvee.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.narvee.Entity.Passport;
import com.example.narvee.Entity.Student;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer> {

	@Query("select p from Student s join s.passport p where s.name = ?1")
	Passport getPassportByStudentName(String name);

	@Query("select s.name from Student s join s.passport p where p.passportNumber=?1")
	String getStudentNameByPassportNumber(String passportNumber);

//	Passport getPassportByStudentName(String name);

}
