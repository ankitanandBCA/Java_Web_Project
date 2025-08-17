package com.emailsender.example.controller;

import com.emailsender.example.entity.UserRegEntity;
import com.emailsender.example.repositry.UserRegRepositry;
import com.emailsender.example.service.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class UserRegController {

    @Autowired
    UserRegService userRegService;

    @Autowired
    UserRegRepositry userRegRepositry;

    @PostMapping("/upload")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public UserRegEntity addfile(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("file") MultipartFile file // <-- yaha pdf ki jagah "file"
    ) throws IOException {
        byte[] filebyte = file.getBytes();
        UserRegEntity ure = new UserRegEntity();
        ure.setName(name);
        ure.setEmail(email);
        ure.setFile(filebyte);

        return userRegService.add(ure);
    }


    @GetMapping("/view/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<byte[]> viewPdf(@PathVariable int id) {
        UserRegEntity ure = userRegService.getById(id);

        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf")
                .header("Content-Disposition", "inline; filename=document.pdf")
                .body(ure.getFile());
    }


    @GetMapping("/users")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public List<UserRegEntity> getUsers() {
        return userRegRepositry.findAll();
    }




}
