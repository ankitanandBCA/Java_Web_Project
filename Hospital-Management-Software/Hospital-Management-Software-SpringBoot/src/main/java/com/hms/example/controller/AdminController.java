package com.hms.example.controller;

import com.hms.example.entity.Admin;
import com.hms.example.entity.DoctorSpecilazion;
import com.hms.example.repository.DocSpecilization;
import com.hms.example.request.AdminLogin;
import com.hms.example.service.AdminService;
import com.hms.example.service.DocSpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
   

    @PostMapping("/addAdmins")
      public Admin add(@RequestBody Admin admin) {
    	  return adminService.addAdmin(admin);
      }
    
    @PostMapping("/login")
    @CrossOrigin(origins="http://127.0.0.1:5500")
    public Boolean loginadmins(@RequestBody AdminLogin al)
    {
    	System.out.println("Login Successfully...");
    	return adminService.loginadmin(al);
    }
    
    @GetMapping("/total")
    @CrossOrigin(origins="http://127.0.0.1:5500")
    public int total()
    {
    	return adminService.totalAdmin();
    	
    }
    
    
    
    
}
