package com.hms.example.repository;

import com.hms.example.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    
}
