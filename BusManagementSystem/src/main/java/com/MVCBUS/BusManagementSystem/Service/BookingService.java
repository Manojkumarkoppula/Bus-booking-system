package com.MVCBUS.BusManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVCBUS.BusManagementSystem.Entity.BookingDetails;
import com.MVCBUS.BusManagementSystem.Repo.BookingRepository;

@Service
public class BookingService {

	@Autowired
    private BookingRepository br;

    // Method to save a list of PassengerDetails
    public List<BookingDetails> saveBookingDetails(List<BookingDetails> bookingdetails) {
        return br.saveAll(bookingdetails); // Use saveAll() to save multiple records
    }
    
    
    public List<BookingDetails> findByBusId(String busId) {
        return br.findByBusId(busId);
    }

    
}