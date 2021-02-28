package com.example.demo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Exam;
import com.example.demo.domain.Question;
import com.example.demo.domain.Simulated;
import com.example.demo.domain.Student;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	// Create a student
	public Student createStudent(Student student) {
		if(student != null) {
			studentRepository.save(student);
		}
		return student;
	}
	
	// Response exam's questions
	public void responseQuestions(Student student, Exam exam, Long idQuestion, String item) {
		
		if(exam != null) {
			List<Question> questions = exam.getQuestions();
			for(Question q : questions) {
				if(q.getId() == idQuestion && q.getCorrectItem() == item) {
					if(q.isEasy()) {
						student.setQuantityEasy(student.getQuantityEasy() + 1);
					}else if(q.isMedium()) {
						student.setQuantityMedium(student.getQuantityMedium() + 1);
					}else if(q.isHard()) {
						student.setQuantityHard(student.getQuantityHard() + 1);
					}
					break;
					
				}
			}
		}
		
	}
	
	// Calculates the student's grade
	public void gradeCalculator(Student student) {
		student.setGrade((student.getQuantityEasy() * 15) + (student.getQuantityMedium() * 12) + (student.getQuantityHard() * 8) + 600);
	}
		
	// Catch all students
	public List<Student> getStudentsWithCalculatedGrade(){
		List<Student> students = studentRepository.findAll();
		for(Student student : students) {
			gradeCalculator(student);
		}
		return students;
	}
	
	// Sorts students by grade
	public List<Student> sortsStudentsByGrade(){
		List<Student> sortedListStudents = getStudentsWithCalculatedGrade();
		Collections.sort(sortedListStudents);
		return sortedListStudents;
	}

	
	

}
