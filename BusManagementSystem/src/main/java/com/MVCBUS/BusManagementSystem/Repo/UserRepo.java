package com.MVCBUS.BusManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVCBUS.BusManagementSystem.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

}
