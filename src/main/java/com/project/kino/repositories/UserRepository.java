package com.project.kino.repositories;

import com.project.kino.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByDeletedAtNullAndEmail(String email);

    List<Users> findByDeletedAtNull();

    Optional<Users> findById(Long id);
}
