package com.project.kino.repositories;

import com.project.kino.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    List<Reviews> findByDeletedAtNullAndAuthor_Email(String email);

}
