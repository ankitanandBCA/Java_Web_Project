package com.househunting.example.controller;

import com.househunting.example.entity.UserReg;
import com.househunting.example.service.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserRegController {

    @Autowired
    UserRegService userRegService;

    @PostMapping("/AddUser")
    public UserReg adduser(@RequestBody UserReg userReg)
    {
        return userRegService.add(userReg);
    }


    @PostMapping("/LoginUser")
    public ResponseEntity<?> loginuser(@RequestBody UserReg userReg)
    {
        String email = userReg.getEmail();
        String password = userReg.getPassword();
        UserReg loginusers = userRegService.loginusers(email, password);
        if(loginusers!=null)
        {
            return ResponseEntity.ok(loginusers);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Faild");
        }
    }


    // total user find
    @GetMapping("/TotalUsers")
    public int usertotal()
    {
        return userRegService.totaluser();
    }
    // get all data of user
    @GetMapping("/AllUsers")
    public List<UserReg> users()
    {
        return userRegService.alluser();
    }

    // delete user data
    @DeleteMapping("/deleteUser/{id}")
    public Boolean deletedatas(@PathVariable int id)
    {
        userRegService.deltedata(id);
        return true;
    }
}
