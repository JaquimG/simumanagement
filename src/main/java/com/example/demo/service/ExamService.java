package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Exam;
import com.example.demo.domain.Question;
import com.example.demo.repository.ExamRepository;


@Service
public class ExamService {
		
	@Autowired
	private ExamRepository examRepository;
	private List<String> feedback;
	
	// add a question on exam
	public Exam addQuestionOnExam(Exam exam, Question question) {
		if(verifyTotalQuantity(exam) < 10) {
			if(question.isEasy()) {
				if(verifyQuantityEasy(exam) < 3) {
					exam.getQuestions().add(question);
				}
			}else if(question.isMedium()) {
				if(verifyQuantityMedium(exam) < 4) {
					exam.getQuestions().add(question);
				}
			}else if(question.isHard()) {
				if(verifyQuantityHard(exam) < 3) {
					exam.getQuestions().add(question);
				}
			}
			return examRepository.save(exam);
		}
		return exam;
	}
	
	
	// create an exam
	public Exam createExam(Exam exam) {
		if(examRepository.findById(exam.getId()) == null) {
			exam.setQuestions(null);
			examRepository.save(exam);
		}
		
		return exam;
	}
	
	// verify how much easy questions we have in exam
	public int verifyQuantityEasy(Exam exam) {
		int count = 0;
		List<Question> questions = exam.getQuestions();
		for(Question q : questions) {
			if(q.isEasy()) {
				count++;
			}
		}
		return count;
	}
	
	// verify how much medium questions we have in exam
	public int verifyQuantityMedium(Exam exam) {
		int count = 0;
		List<Question> questions = exam.getQuestions();
		for(Question q : questions) {
			if(q.isMedium()) {
				count++;
			}
		}
		return count;
	}
	
	// verify how much hard questions we have in exam
	public int verifyQuantityHard(Exam exam) {
		int count = 0;
		List<Question> questions = exam.getQuestions();
		for(Question q : questions) {
			if(q.isHard()) {
				count++;
			}
		}
		return count;
	}
	
	// verify how much questions we have in exam
	public int verifyTotalQuantity(Exam exam) {
		int count = 0;
		List<Question> questions = exam.getQuestions();
		for(Question q : questions) {
			count++;
		}
		return count;
	}
	
	// show feedback of an exam
	public List<String> showFeedback(Exam exam) {
		feedback = null;
		List<Question> questions = exam.getQuestions();
		for(Question q : questions) {
			feedback.add(q.getCorrectItem());
		}
		return feedback;
	}
	
	// show all questions in an exam
	public List<Question> showQuestions(Exam exam){
		List<Question> questions = exam.getQuestions();
		return questions;
	}
	
}
