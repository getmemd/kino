package com.project.kino.repositories;

import com.project.kino.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Users findByID(int id);
    Users findByUsername(String username);
}
