package com.lms.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // IMPORTANT: lowerCamelCase rakho (Jackson getters ke through JSON key "courseName" banega)
    private String courseName;

    private String instructorName;
    private long prize;

    @Lob
    @Column(name = "courseImg", columnDefinition = "LONGBLOB")
    private byte[] courseImage;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Video> videos = new ArrayList<>();

    public Course() {}

    // --- getters/setters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getInstructorName() { return instructorName; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }

    public long getPrize() { return prize; }
    public void setPrize(long prize) { this.prize = prize; }

    public byte[] getCourseImage() { return courseImage; }
    public void setCourseImage(byte[] courseImage) { this.courseImage = courseImage; }

    public List<Video> getVideos() { return videos; }
    public void setVideos(List<Video> videos) { this.videos = videos; }

    // helper (optional)
    public void addVideo(Video v) {
        videos.add(v);
        v.setCourse(this);
    }
    public void removeVideo(Video v) {
        videos.remove(v);
        v.setCourse(null);
    }
}
