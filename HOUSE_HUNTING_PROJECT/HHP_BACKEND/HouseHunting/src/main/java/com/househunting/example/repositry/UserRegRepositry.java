package com.househunting.example.repositry;

import com.househunting.example.entity.UserReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegRepositry extends JpaRepository<UserReg , Integer> {

    UserReg findByEmailAndPassword(String email,String password);
}
