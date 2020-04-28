package com.project.kino.services.impl;

import com.project.kino.entities.Users;
import com.project.kino.repositories.UserRepository;
import com.project.kino.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userRepository.findByDeletedAtNullAndEmail(s);
        User secUser = new User(user.getEmail(), user.getPassword(), user.getRoles());
        return secUser;
    }
}