package com.example.dio.repository;

import com.example.dio.model.User;
import com.example.dio.until.ResponseStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long>{

//    public User save(User user);
}
