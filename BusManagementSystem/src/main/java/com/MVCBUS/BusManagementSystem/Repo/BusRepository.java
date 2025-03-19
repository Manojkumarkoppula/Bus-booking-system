package com.MVCBUS.BusManagementSystem.Repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVCBUS.BusManagementSystem.Entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
	
	
	List<Bus> findBySourceAndDestinationAndDepartureDate(String source, String destination, LocalDate departureDate);}
