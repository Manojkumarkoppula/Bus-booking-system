package com.MVCBUS.BusManagementSystem.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVCBUS.BusManagementSystem.Entity.Bus;
import com.MVCBUS.BusManagementSystem.Repo.BusRepository;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    // Add a new bus
    public Bus addBus(Bus bus) {
        
        return busRepository.save(bus);
    }

    // Get all buses
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Get a bus by ID
    public Optional<Bus> getBusById(Long id) {
        return busRepository.findById(id);
    }

    // Delete a bus by ID
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }
    

    public List<Bus> searchBuses(String source, String destination, String date) {
        LocalDate departureDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return busRepository.findBySourceAndDestinationAndDepartureDate(source, destination, departureDate);
    }
}