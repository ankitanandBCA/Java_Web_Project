package com.emailsender.example.repositry;

import com.emailsender.example.entity.UserRegEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegRepositry extends JpaRepository<UserRegEntity,Integer> {
}
