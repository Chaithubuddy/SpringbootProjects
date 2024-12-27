package com.chaithu.narvee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.chaithu.narvee.Entity.PageDTO;
import com.chaithu.narvee.Entity.Student;

public interface IStudentService {
	
  public abstract Student saveStudent(Student student); 
  public abstract Student updateStudent(Student student); 
  public abstract void  deleteStudent(Integer id); 
  public abstract  Optional<Student> getStudentByid(Integer id); 
  public abstract List<Student> getAllStudents(); 
  
  public abstract Page<Student> createpage(PageDTO pagedto);
  
	

}
