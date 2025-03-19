package com.MVCBUS.BusManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MVCBUS.BusManagementSystem.Entity.Bus;
import com.MVCBUS.BusManagementSystem.Service.BusService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class BusController {

    @Autowired
    private BusService busService;

    // Add a new bus with an image
    @PostMapping("/buses")
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        Bus savedBus = busService.addBus(bus);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBus);
    }
 
    @GetMapping("/buses")
    public List<Bus> getAllBuses() {
         
        return busService.getAllBuses();
    }

    @GetMapping("/buses/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        Optional<Bus> bus = busService.getBusById(id);
        return bus.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/buses/{id}")
    public ResponseEntity<?> deleteBus(@PathVariable Long id) {
        try {
            busService.deleteBus(id);
            return ResponseEntity.ok("Bus deleted successfully");
        } catch (Exception e) {
            // Log the exception
            System.err.println("Error deleting bus: " + e.getMessage());
            return ResponseEntity.status(500).body("Error deleting bus: " + e.getMessage());
        }
    }
    
    @GetMapping("/buses/search")
    public ResponseEntity<List<Bus>> searchBuses(
        @RequestParam String source,
        @RequestParam String destination,
        @RequestParam String date) {
        List<Bus> buses = busService.searchBuses(source, destination, date);
        return ResponseEntity.ok(buses);
    }
}