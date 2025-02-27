package com.example.dio.service.imp;

import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import com.example.dio.until.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {

        return userRepository.save(user);
    }
}
