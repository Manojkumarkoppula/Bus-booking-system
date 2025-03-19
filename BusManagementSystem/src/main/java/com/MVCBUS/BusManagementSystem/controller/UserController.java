package com.MVCBUS.BusManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MVCBUS.BusManagementSystem.Entity.Bus;
import com.MVCBUS.BusManagementSystem.Entity.User;
import com.MVCBUS.BusManagementSystem.Service.UserService;

@RestController
@CrossOrigin(origins ="http://localhost:5173")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/test")
	 public ResponseEntity<User> adduserdata(@RequestBody User u) {
        User savedUser = us.addUser(u);
        return ResponseEntity.ok(savedUser);
	}
	
	@GetMapping("/users")
    public List<User> AllUser() {
         
        return us.getAllUsers();
    }
}
