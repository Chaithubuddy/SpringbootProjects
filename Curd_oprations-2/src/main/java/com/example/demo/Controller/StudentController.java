package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.example.demo.Entity.SortDTO;
import com.example.demo.Entity.Student;
import com.example.demo.Service.IStudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("Student")
@Slf4j
public class StudentController {
	@Autowired
	private IStudentService studentService;

	@PostMapping("save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        System.out.println(student);
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Optional<Student> studata = studentService.getStudentById(student.getId());

		if (studata.isPresent()) {
			Student data = studata.get();
			data.setName(student.getName());
			data.setQual(student.getQual());
			data.setMarks(student.getMarks());
			Student updatedStudent = studentService.saveStudent(data);
			return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
//        //Optional<Student> existingStudentOpt = studentService.getStudentById(student.getId());
//        if (existingStudentOpt.isPresent()) {
//            Student existingStudent = existingStudentOpt.get();
//            existingStudent.setName(student.getName());
//            existingStudent.setQual(student.getQual());
//            existingStudent.setMarks(student.getMarks());
//            Student updatedStudent = studentService.saveStudent(existingStudent);
//            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<Student>(HttpStatus.OK);

	}

	@GetMapping("getBY/{id}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable Integer id) {
		Optional<Student> student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);

	}

	@GetMapping("{pageNumber}/{pageSize}")
	public ResponseEntity<List<Student>> getAllStudent(
			@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("pageSize") Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<Student> getingAllStudent = studentService.getAllStudent(pageable);
		return new ResponseEntity<List<Student>>(getingAllStudent, HttpStatus.OK);
	}
	
	@PostMapping("/all")
	public ResponseEntity<Page<Student>> getAll(@RequestBody SortDTO sortdto){
		Page<Student>  Pagestudent      = studentService.getall(sortdto);
		return new ResponseEntity(Pagestudent,HttpStatus.OK);
		
		
		
		
	}
	
}
