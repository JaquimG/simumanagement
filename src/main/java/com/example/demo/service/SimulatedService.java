package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Simulated;
import com.example.demo.repository.SimulatedRepository;

@Service
public class SimulatedService {
	
	@Autowired
	private SimulatedRepository simulatedRepository;
	
	
	// Create a simulated in Database
	public Simulated create(Simulated simulated) {
		return simulatedRepository.save(simulated);
	}
	
	// List all simulateds in Database
	public List<Simulated> showAllSimulated(){
		List<Simulated> simulateds = simulatedRepository.findAll();
		return simulateds;
	}
	
	
	

}
