package com.lms.example.controller;

import com.lms.example.entity.Video;
import com.lms.example.repositry.VideoRepository;
import com.lms.example.service.VideoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/videos")
@CrossOrigin(origins = {"https://lmssoftware-7c720.web.app", "http://localhost:5500", "http://127.0.0.1:5500", "*"})
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoRepository videoRepository;

    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("description") String description,
                              @RequestParam("file") MultipartFile file,
                              @RequestParam("courseid") Long courseId) {
        try {
            Video savedVideo = videoService.saveVideo(description, file, courseId);
            return "Video uploaded successfully! ID: " + savedVideo.getId();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }


    @GetMapping("/All")
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @GetMapping("/by-course/{courseId}")
    public List<Video> getByCourse(@PathVariable int courseId) {
        return videoRepository.findByCourse_Id(courseId);
    }

    @GetMapping("/play/{id}")
    public void streamVideo(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        File file = new File(video.getFilePath());
        if (!file.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String mime = Files.probeContentType(file.toPath());
        response.setContentType(mime != null ? mime : "video/mp4");
        response.setHeader("Accept-Ranges", "bytes");
        Files.copy(file.toPath(), response.getOutputStream());
    }

    @GetMapping("/byCourse")
    public List<Video> getVideosByCourse(@RequestParam("courseid") Long courseId) {
        return videoRepository.findByCourse_Id(Math.toIntExact(courseId));
    }

}
