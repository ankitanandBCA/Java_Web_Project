package com.hms.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.example.entity.DoctorSpecilazion;
import com.hms.example.service.DocSpc;

@RestController
@RequestMapping("/doctor")
public class Ds {
	
	 @Autowired
	    DocSpc dss;
	 @PostMapping("/spec")
	   @CrossOrigin(origins="http://127.0.0.1:5500")
	    public DoctorSpecilazion get(@RequestBody DoctorSpecilazion d)
	    {  
	    	return dss.getadd(d);
	    	
	    }
	 
	 @GetMapping("/get")
	 @CrossOrigin(origins="http://127.0.0.1:5500")
	 public List<DoctorSpecilazion> get()
	 {
		return dss.getdata();
	 }
	 
	 @GetMapping("/count")
	 @CrossOrigin(origins="http://127.0.0.1:5500")
	 public int dsss()
	 {
		 return dss.dsc();
	 }

}
