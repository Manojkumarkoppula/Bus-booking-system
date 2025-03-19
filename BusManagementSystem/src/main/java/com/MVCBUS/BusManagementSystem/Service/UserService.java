package com.MVCBUS.BusManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVCBUS.BusManagementSystem.Entity.Bus;
import com.MVCBUS.BusManagementSystem.Entity.User;
import com.MVCBUS.BusManagementSystem.Repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;
	
	public User addUser(User u)
	{
		return ur.save(u);
	}
	
	public List<User> getAllUsers() {
        return ur.findAll();
    }


}
