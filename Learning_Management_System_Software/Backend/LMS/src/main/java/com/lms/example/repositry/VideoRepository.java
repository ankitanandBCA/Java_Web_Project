package com.lms.example.repositry;

import com.lms.example.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByCourse_Id(int courseId);
}
