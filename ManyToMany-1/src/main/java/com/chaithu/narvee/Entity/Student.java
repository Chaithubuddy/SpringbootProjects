package com.chaithu.narvee.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//main class

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stuid;
	private String name;
	private String qual;
	private Double marks; 
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Course.class)
	@JoinTable(name = "StudentCoursetable", 
	             joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "stuid"), 
	      inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseid"))
	private Set<Course> courses;
}
