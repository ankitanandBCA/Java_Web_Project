package com.hms.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.example.entity.DoctorSpecilazion;

@Repository
public interface DocSpecilization extends JpaRepository<DoctorSpecilazion, Integer> {

}
