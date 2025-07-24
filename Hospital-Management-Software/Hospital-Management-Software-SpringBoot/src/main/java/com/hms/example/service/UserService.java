package com.hms.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.example.entity.User;
import com.hms.example.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo ur;
	
	
	public User addUser(User u)
	{
		 return ur.save(u);
	}
	
	
	public User loginuser(String email,String password)
	{
		return ur.findByEmailAndPassword(email, password);
	}

}
