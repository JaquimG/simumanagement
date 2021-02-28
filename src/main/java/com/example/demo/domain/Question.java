package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean isEasy;
	
	private boolean isMedium;
	
	private boolean isHard;

	
	@ManyToOne
	@JoinColumn(name = "EXAM_ID")
	private Exam exam;
	
	private String correctItem;
	
	private String description;
	
	private String items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEasy() {
		return isEasy;
	}

	public void setEasy(boolean isEasy) {
		if(isMedium || isHard) {
			this.isEasy = false;
		}else {
			this.isEasy = isEasy;
		}
	}

	public boolean isMedium() {
		return isMedium;
	}

	public void setMedium(boolean isMedium) {
		if(isEasy || isHard) {
			this.isMedium = false;
		}else {
			this.isMedium = isMedium;
		}
	}

	public boolean isHard() {
		return isHard;
	}

	public void setHard(boolean isHard) {
		if(isEasy || isMedium) {
			this.isHard = false;
		}else {
			this.isHard = isHard;
		}
	}
	

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getCorrectItem() {
		return correctItem;
	}

	public void setCorrectItem(String correctItem) {
		this.correctItem = correctItem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	

	
	
	
	
	
	
	
	
}
