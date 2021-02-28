package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Student implements Comparable<Student>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private double grade;

	private int quantityEasy;
	
	private int quantityMedium;
	
	private int quantityHard;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}


	public int getQuantityEasy() {
		return quantityEasy;
	}

	public void setQuantityEasy(int quantityEasy) {
		this.quantityEasy = quantityEasy;
	}

	public int getQuantityMedium() {
		return quantityMedium;
	}

	public void setQuantityMedium(int quantityMedium) {
		this.quantityMedium = quantityMedium;
	}

	public int getQuantityHard() {
		return quantityHard;
	}

	public void setQuantityHard(int quantityHard) {
		this.quantityHard = quantityHard;
	}

	@Override
	public int compareTo(Student anotherStudent) {
		if(this.getGrade() > anotherStudent.getGrade()) {
			return -1;
		}else if(this.getGrade() < anotherStudent.getGrade()) {
			return 1;
		}else {
			return 0;
		}
	}

	
	
	
	
}
