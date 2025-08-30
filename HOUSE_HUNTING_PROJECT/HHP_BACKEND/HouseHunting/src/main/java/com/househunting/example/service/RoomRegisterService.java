package com.househunting.example.service;

import com.househunting.example.entity.RoomRegister;
import com.househunting.example.repositry.RegisterRoomRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomRegisterService {

    @Autowired
    RegisterRoomRepositry registerRoomRepositry;

    public RoomRegister add(RoomRegister roomRegister)
    {
        return registerRoomRepositry.save(roomRegister);
    }


    // get all data
    public List<RoomRegister> getalldata()
    {
        return registerRoomRepositry.findAll();
    }

     // get by id to update
    public RoomRegister getById(int id) {
        return registerRoomRepositry.findById(id).orElse(null);
    }

    // delete
    public Boolean deleteData(int id)
    {
         registerRoomRepositry.deleteById(id);
         return true;
    }

    // count all room
    public int countall()
    {
        return Math.toIntExact(registerRoomRepositry.count());
    }

}
