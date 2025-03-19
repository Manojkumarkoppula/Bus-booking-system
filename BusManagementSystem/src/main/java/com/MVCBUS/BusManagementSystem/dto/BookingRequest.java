package com.MVCBUS.BusManagementSystem.dto;

import java.util.List;

import com.MVCBUS.BusManagementSystem.Entity.BookingDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
	
	private String busId;
    private double totalFareAmount;
    private List<BookingDetails> bookingdetails;

}
    
