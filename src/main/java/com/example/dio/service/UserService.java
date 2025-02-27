package com.example.dio.service;

import com.example.dio.model.User;
import com.example.dio.until.ResponseStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface UserService {

   public User registerUser(User user);
}
