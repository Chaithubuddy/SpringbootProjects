package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String Qual;
	private Double marks;

	@ManyToMany
	@JoinTable(name = "Student_Course", 
	    joinColumns = @JoinColumn(name = "Student_id"), 
        inverseJoinColumns = @JoinColumn(name = "Course_id"))
	private List<Courses> courses;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PassportTable_id")
	private Passport passport;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private  List<Department> department;

}
