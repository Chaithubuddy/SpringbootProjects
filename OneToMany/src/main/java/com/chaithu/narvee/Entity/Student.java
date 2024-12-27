package com.chaithu.narvee.Entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer stuId;
	private String name;
	private String qual;
	private Double marks;
	@OneToMany(cascade = CascadeType.ALL,
			targetEntity = Department.class,
			orphanRemoval = true,fetch = FetchType.LAZY)
	@JoinColumn(name="Student_id",referencedColumnName = "stuId")
	private Set<Department>department;
}
