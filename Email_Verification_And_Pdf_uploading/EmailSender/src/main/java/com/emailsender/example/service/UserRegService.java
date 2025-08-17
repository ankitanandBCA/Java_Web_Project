package com.emailsender.example.service;

import com.emailsender.example.entity.UserRegEntity;
import com.emailsender.example.repositry.UserRegRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegService {

    @Autowired
    UserRegRepositry userRegRepositry;

    public UserRegEntity add(UserRegEntity userRegEntity)
    {
        return userRegRepositry.save(userRegEntity);
    }


    public UserRegEntity getById(int id) {
        return userRegRepositry.findById(id).orElseThrow(() -> new RuntimeException("File Not Found"));
    }



}
