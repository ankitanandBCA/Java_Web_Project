package com.hms.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.example.entity.Doctor;
import com.hms.example.repository.DoctorRepositry;

@Service
public class DoctorService {
	@Autowired
	DoctorRepositry dr;
	
	public Doctor Add(Doctor d)
	{
		return dr.save(d);
	}
    
	
	public Doctor logindoctor(String email,String password)
	{
		return dr.findByEmailAndPassword(email, password);
	}
	
	
	public int countDoctor()
	{
		return (int) dr.count();
		
		
	}
	
	
	public List<Doctor> getall()
	{
		return dr.findAll();
	}
	
	
	public Boolean deletedoctor(String id)
	{
		 dr.deleteById(id);
		 return true;
	}
	
	
	
}
