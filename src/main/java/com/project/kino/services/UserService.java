package com.project.kino.services;

import com.project.kino.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    Users getUserByEmail(String email);
    boolean saveUser(Users user);
}
