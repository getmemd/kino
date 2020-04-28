package com.project.kino.repositories;

import com.project.kino.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAllByDeletedAtNullOrderByCreatedAtDesc();

    Posts findByDeletedAtNullAndId(Long id);

}
