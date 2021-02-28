package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToMany(mappedBy = "exam") 
	private List<Question> questions;
	
	private String examType;
	
	@ManyToOne
	@JoinColumn(name = "SIMULATED_ID")
	private Simulated simulated;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public Simulated getSimulated() {
		return simulated;
	}

	public void setSimulated(Simulated simulated) {
		this.simulated = simulated;
	}

	
	
	
	
	
}
