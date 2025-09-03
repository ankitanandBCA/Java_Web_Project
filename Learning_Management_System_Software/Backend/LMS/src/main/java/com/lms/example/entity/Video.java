package com.lms.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonBackReference       // Course.videos ke sath infinite loop ko roke
    private Course course;

    // --- getters/setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    // (Optional) Agar /videos/All me course object nahi bhejna chahte:
    @JsonIgnore
    public Integer getCourseIdOnly() {
        return (course != null) ? course.getId() : null;
    }
}
