package com.project.kino.repositories;

import com.project.kino.entities.Genres;
import com.project.kino.entities.Movies;
import com.project.kino.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Long> {

}
