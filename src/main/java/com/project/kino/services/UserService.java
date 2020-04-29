package com.project.kino.services;

import com.project.kino.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    boolean saveUser(Users user);
}
