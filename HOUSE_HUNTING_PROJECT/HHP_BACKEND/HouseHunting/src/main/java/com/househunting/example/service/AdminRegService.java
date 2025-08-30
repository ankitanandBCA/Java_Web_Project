package com.househunting.example.service;

import com.househunting.example.entity.AdminReg;
import com.househunting.example.repositry.AdminRegRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRegService {

    @Autowired
    AdminRegRepositry adminRegRepositry;

    // Add Admin
    public AdminReg add(AdminReg adminReg)
    {
        return adminRegRepositry.save(adminReg);
    }

    // return all admin
    public List<AdminReg> getall()
    {
        return adminRegRepositry.findAll();
    }

    // login admin
    public AdminReg loginAdmins(String email,String password)
    {
        return adminRegRepositry.findByEmailAndPassword(email, password);
    }

    // count total admin

    public int total()
    {
        return Math.toIntExact(adminRegRepositry.count());
    }

    // delete admin

    public Boolean deleteAdmin(int id)
    {
        adminRegRepositry.deleteById(id);
        return true;
    }


    // update by password
    // update admin password
    public AdminReg updatePassword(int id, String newPassword) {
        AdminReg admin = adminRegRepositry.findById(id).orElse(null);
        if (admin != null) {
            admin.setPassword(newPassword);
            return adminRegRepositry.save(admin);
        }
        return null;
    }

}
