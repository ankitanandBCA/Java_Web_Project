package com.househunting.example.controller;

import com.househunting.example.entity.LandLoardReg;
import com.househunting.example.service.LandLoardRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LandLoardRegController {

    @Autowired
    LandLoardRegService landLoardRegService;

    @PostMapping("/AddLandLoard")
    public LandLoardReg addlandloard(@RequestBody LandLoardReg landLoardReg)
    {
        return landLoardRegService.add(landLoardReg);
    }

    // login landloard

    @PostMapping("/LoginLandLoard")
    public ResponseEntity<?> loginland(@RequestBody LandLoardReg landLoardReg)
    {
        String email = landLoardReg.getEmail();
        String password = landLoardReg.getPassword();

        LandLoardReg loginglandloard = landLoardRegService.loginglandloard(email, password);
           if(loginglandloard!=null)
           {
               return ResponseEntity.ok(loginglandloard);
           }
           else {
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login faild");
           }
    }

    // total land loard count

    @GetMapping("/TotalLandLoard")
    public int toatllandloard()
    {
        return landLoardRegService.total();
    }

    // get all landloard
    @GetMapping("/AllLandLoards")
    public List<LandLoardReg> alldata()
    {
        return landLoardRegService.all();
    }

    // delete landloard bu Admin

    @DeleteMapping("/deleteLandLoard/{id}")
    public Boolean deleteLand(@PathVariable int id)
    {
        landLoardRegService.deletelandloard(id);
        return true;
    }

}
