package com.househunting.example.service;

import com.househunting.example.entity.LandLoardReg;
import com.househunting.example.repositry.LandLoardRegRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandLoardRegService {

    @Autowired
    LandLoardRegRepositry landLoardRegRepositry;

    // add landloard
    public LandLoardReg add(LandLoardReg landLoardReg)
    {
        return landLoardRegRepositry.save(landLoardReg);
    }

    // login landloard
    public LandLoardReg loginglandloard(String email,String password)
    {
        return landLoardRegRepositry.findByEmailAndPassword(email, password);
    }
    // total landloard
    public int total()
    {
        return Math.toIntExact(landLoardRegRepositry.count());
    }

    // get all landloard
    public List<LandLoardReg> all()
    {
        return landLoardRegRepositry.findAll();
    }

    // delete landloard
    public Boolean deletelandloard(int id)
    {
        landLoardRegRepositry.deleteById(id);
        return true;
    }

}
