package com.hms.example.service;

import com.hms.example.controller.AdminController;
import com.hms.example.entity.Admin;
import com.hms.example.repository.AdminRepository;
import com.hms.example.request.AdminLogin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {



    @Autowired
    private AdminRepository adminRepository;

 
    
    public Admin addAdmin(Admin admin)
    {
    	return adminRepository.save(admin);
    }
    
    
    public Boolean loginadmin(AdminLogin adminlogin) {
    	  Optional<Admin> optionalAdmin = adminRepository.findById(adminlogin.getUserId());
    	     Admin a=optionalAdmin.get();
    	     if(a==null)
    	    	 return false;
    	     
    	     if(!a.getPassword().equals(adminlogin.getPassword()))
    	    	 return false;
			return true;
    	  
    	
    }
    
    
    public int totalAdmin() {
        return (int)adminRepository.count();
    }

}
