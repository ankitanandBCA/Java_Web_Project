package com.hms.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    
   
    @Id
    private String email;

   
    private String password;

    // Constructors
    public Admin() {}

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
