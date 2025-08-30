package com.househunting.example.repositry;

import com.househunting.example.entity.AdminReg;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRegRepositry extends JpaRepository<AdminReg,Integer> {

    AdminReg findByEmailAndPassword(String email,String password);
}
