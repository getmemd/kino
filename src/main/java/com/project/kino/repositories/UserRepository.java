package com.project.kino.repositories;

import com.project.kino.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByDeletedAtNullAndEmail(String email);

}
