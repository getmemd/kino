package com.project.kino.services;

import com.project.kino.entities.Users;
import com.project.kino.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    boolean saveUser(Users user);
}
