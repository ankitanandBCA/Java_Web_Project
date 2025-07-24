package com.hms.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hms.example.entity.User;

public interface UserRepo extends JpaRepository<User, String> {
    // Custom login query
    User findByEmailAndPassword(String email, String password);
}
