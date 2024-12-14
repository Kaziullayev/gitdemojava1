package com.example.demojava1.Services;

import com.example.demojava1.Registration.UserRegistration;
import com.example.demojava1.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistration user);
}