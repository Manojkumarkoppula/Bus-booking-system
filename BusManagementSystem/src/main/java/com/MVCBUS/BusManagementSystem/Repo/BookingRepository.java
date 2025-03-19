package com.MVCBUS.BusManagementSystem.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVCBUS.BusManagementSystem.Entity.BookingDetails;


@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, Long> {
	
	List<BookingDetails> findByBusId(String busId);
}
