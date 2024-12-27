package com.example.narvee.Controller;

import java.io.File;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.narvee.Entity.Passport;
import com.example.narvee.Entity.Student;
import com.example.narvee.Entity.pageDTO;
import com.example.narvee.Service.IStudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("Student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping("save")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student saveStudent = studentService.saveStudent(student);
		return ResponseEntity.ok(saveStudent);

	}

	@PutMapping("update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student updateStudent = studentService.updateStudent(student);
		return ResponseEntity.ok(updateStudent);

	}

	@PostMapping("page")
	public ResponseEntity<Page<Student>> studentPagination(@RequestBody pageDTO pagedto) {
		Page<Student> studentpage = studentService.getPagination(pagedto);
		return new ResponseEntity<Page<Student>>(studentpage, HttpStatus.CREATED);

	}

	@GetMapping("/passport/{name}")
	public ResponseEntity<Passport> getPassportByStudentName(@PathVariable String name) {
		Passport passportNumber = studentService.getPassportByStudentName(name);
		return new ResponseEntity<Passport>(passportNumber, HttpStatus.OK);

	}

	@GetMapping("pas/{name}")
	public ResponseEntity<String> getStudentNameppid(@PathVariable("name") String passportNumber) {
		String name = studentService.getNameByPId(passportNumber);
		return ResponseEntity.ok(name);
	}

	@PostMapping("file")
	public void fileUpload(@RequestParam("Studentdata") MultipartFile upload) throws Exception {
		System.out.println(upload.getContentType());
		//String filepath="C:\\virat\\to\\your\\"+upload.getContentType();
		File file=new File("C:\\virat\\to\\your\\"+upload.getOriginalFilename());
		upload.transferTo(file);

	}
}
