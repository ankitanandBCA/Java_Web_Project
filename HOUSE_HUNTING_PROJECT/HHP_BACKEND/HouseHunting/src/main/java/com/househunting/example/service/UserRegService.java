package com.househunting.example.service;

import com.househunting.example.entity.UserReg;
import com.househunting.example.repositry.UserRegRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegService {

    @Autowired
    UserRegRepositry userRegRepositry;

    public UserReg add(UserReg userReg)
    {
        return userRegRepositry.save(userReg);
    }

    public UserReg loginusers(String email,String password)
    {
        return userRegRepositry.findByEmailAndPassword(email, password);
    }

    // count user reg
    public int totaluser()
    {
        return Math.toIntExact(userRegRepositry.count());
    }

    // get all user
    public List<UserReg> alluser()
    {
        return userRegRepositry.findAll();
    }

    // delete user by admin
    public Boolean deltedata(int id)
    {
        userRegRepositry.deleteById(id);
        return true;
    }
}
