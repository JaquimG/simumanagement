package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Simulated;

public interface SimulatedRepository extends JpaRepository<Simulated, Long>{

}
