package com.emailsender.example.entity;

import jakarta.persistence.*;

@Entity
public class UserRegEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String email;
@Lob
@Column(name = "file", columnDefinition = "LONGBLOB")
private byte[] file;

    public UserRegEntity(int id, String name, String email, byte[] file) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.file = file;
    }
    public UserRegEntity()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
