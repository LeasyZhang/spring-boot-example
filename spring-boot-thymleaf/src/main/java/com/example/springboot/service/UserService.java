package com.example.springboot.service;

import com.example.springboot.controller.dto.UserRegistrationDto;
import com.example.springboot.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
