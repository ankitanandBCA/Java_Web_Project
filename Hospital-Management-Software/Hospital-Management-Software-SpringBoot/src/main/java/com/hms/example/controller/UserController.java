package com.hms.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.example.entity.User;
import com.hms.example.request.UserLogin;
import com.hms.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping("/addUser")
	 @CrossOrigin(origins="http://127.0.0.1:5500")
	public User Add(@RequestBody User u)
	{
		return us.addUser(u);
	}
	
	 @PostMapping("/login")
	 @CrossOrigin(origins="http://127.0.0.1:5500")
	    public ResponseEntity<?> loginUser(@RequestBody User user) {
	        // Sanitize input (optional)
	        String email = user.getEmail().trim();
	        String password = user.getPassword().trim();

	        User u = us.loginuser(email, password);

	        if (u != null) {
	            return ResponseEntity.ok(u);
	        } else {
	            return ResponseEntity.status(401).body("Invalid credentials");
	        }
	    }

}
