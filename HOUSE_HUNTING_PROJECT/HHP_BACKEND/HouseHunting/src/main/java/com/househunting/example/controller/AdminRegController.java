package com.househunting.example.controller;

import com.househunting.example.entity.AdminReg;
import com.househunting.example.service.AdminRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AdminRegController {

    @Autowired
    AdminRegService adminRegService;

    @PostMapping("/AddAdmin")
    public AdminReg addAdmin(@RequestBody AdminReg adminReg)
    {
        return adminRegService.add(adminReg);
    }

    @GetMapping("/AllAdmin")
    public List<AdminReg> getallAdmin()
    {
        return adminRegService.getall();
    }

    // login admin

    @PostMapping("/AdminLogin")
    public ResponseEntity<?> login(@RequestBody AdminReg adminReg)
    {
        String email = adminReg.getEmail();
        String password = adminReg.getPassword();

        AdminReg adminReg1 = adminRegService.loginAdmins(email, password);
        if(adminReg1 != null)
        {
            return ResponseEntity.ok(adminReg1);
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Fail");
        }
    }


    // count total admin

    @GetMapping("/TotalAdmin")
    public int countAdmin()
    {
        return adminRegService.total();
    }

    // delete by Admin
    @DeleteMapping("/DeleteAdmin/{id}")
    public Boolean deleteAdmindata(@PathVariable int id)
    {
        adminRegService.deleteAdmin(id);
        return true;
    }

    // update by admin
    @PutMapping("/UpdateAdmin/{id}")
    public ResponseEntity<?> updateAdminPassword(@PathVariable int id, @RequestBody AdminReg adminDetails) {
        AdminReg updatedAdmin = adminRegService.updatePassword(id, adminDetails.getPassword());
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
        }
    }

}
