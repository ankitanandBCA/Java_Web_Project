package com.hms.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.example.entity.Doctor;
import com.hms.example.service.DoctorService;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {
	
	@Autowired
	DoctorService ds;
	
	@PostMapping("/add")
	@CrossOrigin(origins="http://127.0.0.1:5500")
	public Doctor add(@RequestBody Doctor d)
	{
		return ds.Add(d);
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://127.0.0.1:5500")
	public ResponseEntity<?> DoctorLogin(@RequestBody Doctor d)
	{
		String email=d.getEmail();
		String password=d.getPassword();
		       
		      Doctor d1 =ds.logindoctor(email, password);
		      if (d1 != null) {
		            return ResponseEntity.ok(d1);
		        } else {
		            return ResponseEntity.status(401).body("Invalid credentials");
		        }
	}
	
	@GetMapping("/count")
	@CrossOrigin(origins="http://127.0.0.1:5500")
	public int Count()
	{
		return ds.countDoctor();
	}
	
	@GetMapping("/getdoctor")
	@CrossOrigin(origins="http://127.0.0.1:5500")
	public List<Doctor> getalldoctor(){
		return ds.getall();
	}
	

	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins="http://127.0.0.1:5500")
	public Boolean deletedoctors(@PathVariable String id)
	{
	   return ds.deletedoctor(id);
		
	}

	
	
	
}
