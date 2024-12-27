package com.chaithu.narvee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaithu.narvee.Entity.PageDTO;
import com.chaithu.narvee.Entity.Student;
import com.chaithu.narvee.Service.IStudentService;

@RestController
@RequestMapping("Student")
public class StudentController {

	@Autowired
	private IStudentService Stduentservice;

	@PostMapping("save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student createdStudent = Stduentservice.saveStudent(student);
		return ResponseEntity.ok(createdStudent);

	}

	@PutMapping("update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student updatedStudent = Stduentservice.updateStudent(student);
		return ResponseEntity.ok(updatedStudent);

	}

	@GetMapping("getAll")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> allStudent = Stduentservice.getAllStudents();
		return ResponseEntity.ok(allStudent);
	}

	@GetMapping("getId/{id}")
	public ResponseEntity<Optional<Student>> getStudentByid(@PathVariable("id") Integer id) {
		Optional<Student> studentById = Stduentservice.getStudentByid(id);
		return ResponseEntity.ok(studentById);
	}

	@PostMapping("page")
	public ResponseEntity<Page> crratingPage(@RequestBody PageDTO pagedto) {
		Page pageStudent = Stduentservice.createpage(pagedto);
		return new ResponseEntity<Page>(pageStudent, HttpStatus.OK);
	}
}
