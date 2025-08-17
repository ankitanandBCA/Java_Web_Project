package com.emailsender.example.controller;

import com.emailsender.example.entity.Student;
import com.emailsender.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentService.registerStudent(student);
        return "Registration Successful! Check your email.";
    }
}
