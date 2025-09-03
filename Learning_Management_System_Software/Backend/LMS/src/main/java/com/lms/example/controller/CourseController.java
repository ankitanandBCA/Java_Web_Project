package com.lms.example.controller;

import com.lms.example.entity.Course;
import com.lms.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://lmssoftware-7c720.web.app")
public class CourseController {

    @Autowired
    CourseService courseService;


    @PostMapping("/AddCourses")
    public Course adcourse(
            @RequestParam("file") MultipartFile file,
            @RequestParam("courseName") String courseName,
            @RequestParam("instructorName") String instructorName,
            @RequestParam("prize") long prize
    ) throws IOException {

        byte[] imagebyte = file.getBytes();

        Course course = new Course();
        course.setCourseImage(imagebyte);
        course.setCourseName(courseName);
        course.setInstructorName(instructorName);
        course.setPrize(prize);

        return courseService.add(course);
    }



    @GetMapping("/AllCoursesss")
    public List<Course> allCoursess()
    {
        return courseService.getalldata();
    }
}
