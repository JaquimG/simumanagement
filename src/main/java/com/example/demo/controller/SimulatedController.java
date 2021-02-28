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

import com.example.demo.domain.Simulated;
import com.example.demo.service.SimulatedService;

@RestController
@RequestMapping(value = "/simulateds")
public class SimulatedController {
	
	@Autowired
	private SimulatedService simulatedService;
	
	
	
	// Endpoint for create a simulated
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Simulated simulated){
		simulated = simulatedService.create(simulated);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(simulated.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	// Endpoint for show all simulateds in Database
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Simulated>> showAll() {
		return ResponseEntity.status(HttpStatus.OK).body(simulatedService.showAllSimulated());
	}
	
	
	
	
	

}
