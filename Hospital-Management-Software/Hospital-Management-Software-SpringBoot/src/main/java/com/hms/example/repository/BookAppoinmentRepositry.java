package com.hms.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.example.entity.BookAppoinment;

@Repository
public interface BookAppoinmentRepositry extends JpaRepository<BookAppoinment, String> {

}
