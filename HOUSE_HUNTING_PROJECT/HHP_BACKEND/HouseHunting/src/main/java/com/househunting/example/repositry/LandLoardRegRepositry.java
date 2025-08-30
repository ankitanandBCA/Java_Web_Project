package com.househunting.example.repositry;

import com.househunting.example.entity.LandLoardReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandLoardRegRepositry extends JpaRepository<LandLoardReg,Integer> {

    LandLoardReg findByEmailAndPassword(String email,String password);
}
