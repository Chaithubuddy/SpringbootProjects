package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.IStudentService;

@RestController
@RequestMapping("Student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student saveStudent = studentService.saveStudent(student);
		return new ResponseEntity<>(saveStudent, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student updateStudent = studentService.updateStudent(student);
		return new ResponseEntity<>(updateStudent, HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<Student>(HttpStatus.OK);

	}

	@GetMapping("getid/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Integer id) {
		Optional<Student> getingStudent = studentService.getByIdStudent(id);
		return new ResponseEntity<>(getingStudent, HttpStatus.OK);
	}

	@GetMapping("{pageNumber}/{pageSize}")
	public ResponseEntity<List<Student>> getAllStudent(
			@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("pageSize") Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<Student> getingAllStudent = studentService.getAllStudent(pageable);
		return new ResponseEntity<List<Student>>(getingAllStudent, HttpStatus.OK);
	}

}
