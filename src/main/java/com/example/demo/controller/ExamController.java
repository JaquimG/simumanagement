package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Exam;
import com.example.demo.domain.Question;
import com.example.demo.domain.Simulated;
import com.example.demo.service.ExamService;

@RestController
@RequestMapping(value = "/exams")
public class ExamController {
		
	@Autowired
	private ExamService examService;
	
	
	// Endpoint for create an exam
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Exam exam){
		exam = examService.createExam(exam);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(exam.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	// Endpoint for show all correct items in exam
	@RequestMapping(value = "/feedbacks", method = RequestMethod.POST)
	public ResponseEntity<List<String>> show(@RequestBody Exam exam) {
		return ResponseEntity.status(HttpStatus.OK).body(examService.showFeedback(exam));
	}
	
	
	// Endpoint for create a question for exam
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Exam exam, @RequestBody Question question){
		exam = examService.addQuestionOnExam(exam, question);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(exam.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
