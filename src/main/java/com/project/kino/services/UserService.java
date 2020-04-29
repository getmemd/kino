package com.project.kino.services;

import com.project.kino.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {
    boolean saveUser(Users user);

    List<Users> getAllUsers();

    Optional<Users> getUserById(Long id);

    void updateUser(Users user);

    void deleteUser(Users user);
}
