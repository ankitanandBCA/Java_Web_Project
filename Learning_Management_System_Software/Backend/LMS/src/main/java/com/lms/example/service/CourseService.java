package com.lms.example.service;

import com.lms.example.entity.Course;
import com.lms.example.repositry.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public Course add(Course course)
    {
       return courseRepo.save(course);
    }

    public List<Course> getalldata()
    {
        return courseRepo.findAll();
    }
}
