package com.househunting.example.repositry;

import com.househunting.example.entity.RoomRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRoomRepositry extends JpaRepository<RoomRegister,Integer> {
}
