package com.MVCBUS.BusManagementSystem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MVCBUS.BusManagementSystem.Entity.BookingDetails;
import com.MVCBUS.BusManagementSystem.Service.BookingService;
import com.MVCBUS.BusManagementSystem.dto.BookingRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor  // Removes @Autowired issue
public class BookingController {

    private final BookingService bs;

    @PostMapping("/bookings")
    public ResponseEntity<String> bookSeats(@RequestBody BookingRequest bookingRequest) {
        List<BookingDetails> passengers = bookingRequest.getBookingdetails();
        
        for (BookingDetails passenger : passengers) {
            passenger.setBusId(bookingRequest.getBusId());
            passenger.setTotalFareAmount(bookingRequest.getTotalFareAmount());
        }
        
    bs.saveBookingDetails(passengers);
        return ResponseEntity.ok("Seats booked successfully!");
    }

    @GetMapping("/bookings/{busId}")
    public ResponseEntity<List<BookingDetails>> getBookingsByBusId(@PathVariable String busId) {
        List<BookingDetails> bookings = bs.findByBusId(busId);
        return ResponseEntity.ok(bookings);
    }
}
