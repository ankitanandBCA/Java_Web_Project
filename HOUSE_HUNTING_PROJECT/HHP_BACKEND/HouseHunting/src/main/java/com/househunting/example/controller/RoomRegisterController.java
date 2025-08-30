package com.househunting.example.controller;

import com.househunting.example.entity.RoomRegister;
import com.househunting.example.service.RoomRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RoomRegisterController {

    @Autowired
    RoomRegisterService roomRegisterService;

    @PostMapping("/RegisterRoom")
    public RoomRegister addroom(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("mobile") long mobile,
            @RequestParam("address") String address,
            @RequestParam("file") MultipartFile fileInput,
            @RequestParam("propertyStutas") String propertyStutas,
            @RequestParam("price")long price
    ) throws IOException {
        byte[] imagebyte = fileInput.getBytes();

        RoomRegister roomRegister = new RoomRegister();
        roomRegister.setName(name);
        roomRegister.setEmail(email);
        roomRegister.setMobile(mobile);
        roomRegister.setAddress(address);
        roomRegister.setImage(imagebyte);
        roomRegister.setPropertyStutas(propertyStutas);
        roomRegister.setPrice(price);

        return roomRegisterService.add(roomRegister);
    }


    // GET MAPPING
    @GetMapping("/AllRooms")
    public List<RoomRegister> findallroom()
    {
        return roomRegisterService.getalldata();
    }

//update by id
@PutMapping("/UpdateStatus/{id}")
public RoomRegister updateStatus(
        @PathVariable int id,
        @RequestParam("propertyStutas") String propertyStutas) {

    RoomRegister room = roomRegisterService.getById(id);
    if (room != null) {
        room.setPropertyStutas(propertyStutas);
        return roomRegisterService.add(room);
    }
    return null;
}


// delete mapping
    @DeleteMapping("/delete/{id}")
    public Boolean deleteroom(@PathVariable int id)
    {
        roomRegisterService.deleteData(id);
        return true;
    }


    // count all room

    @GetMapping("TotalRoom")
    public int allroomcount()
    {
        return roomRegisterService.countall();
    }

}
