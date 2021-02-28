package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Exam;
import com.example.demo.domain.Simulated;
import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	
	
	// Endpoint for create a student
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Student student){
		student = studentService.createStudent(student);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(student.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	// Endpoint for response a question
	@RequestMapping(value = "/responseQuestion", method = RequestMethod.POST)
	public ResponseEntity<Void> responseQuestion(@RequestBody Student student, @RequestBody Exam exam, @PathVariable("id") Long idQuestion, @RequestBody String item){
		studentService.responseQuestions(student, exam, idQuestion, item);
	
		
		return ResponseEntity.noContent().build();
	}
	
	
	// Endpoint for show student's ranking
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> showStudentsRanking() {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.sortsStudentsByGrade());
	}
}
