package com.lms.example.service;

import com.lms.example.entity.Course;
import com.lms.example.entity.Video;
import com.lms.example.repositry.CourseRepo;
import com.lms.example.repositry.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class VideoService {

    @Value("${app.upload.dir}")
    private String uploadDir;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CourseRepo courseRepo;

    public Video saveVideo(String description, MultipartFile file, Long courseId) throws IOException {
        String filePath = uploadDir + File.separator + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        // course nikaalo
        Course course = courseRepo.findById(Math.toIntExact(courseId))
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Video video = new Video();
        video.setDescription(description);
        video.setFilePath(filePath);
        video.setCourse(course);   // 👈 yaha relation set karna important hai

        return videoRepository.save(video);
    }
}
