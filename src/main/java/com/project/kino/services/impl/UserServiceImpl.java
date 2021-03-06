package com.project.kino.services.impl;

import com.project.kino.config.SecurityConfig;
import com.project.kino.entities.Users;
import com.project.kino.repositories.UserRepository;
import com.project.kino.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean saveUser(Users user) {
        Users userFromDB = userRepository.findByDeletedAtNullAndEmail(user.getEmail());
        if (userFromDB != null) {
            return false;
        }
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userRepository.findByDeletedAtNullAndEmail(s);
        User secUser = new User(user.getEmail(), user.getPassword(), user.getRoles());
        return secUser;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void updateUser(Users user) {
        userRepository.save(user);
    }

    public void deleteUser(Users user) {
        userRepository.delete(user);
    }
}
