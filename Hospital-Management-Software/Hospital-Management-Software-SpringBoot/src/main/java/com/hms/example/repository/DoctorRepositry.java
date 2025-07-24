package com.hms.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.example.entity.Doctor;

@Repository
public interface DoctorRepositry extends JpaRepository<Doctor, String> {
	
	Doctor findByEmailAndPassword(String email,String password);

}
