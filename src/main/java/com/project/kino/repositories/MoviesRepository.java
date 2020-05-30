package com.project.kino.repositories;

import com.project.kino.entities.Actors;
import com.project.kino.entities.Genres;
import com.project.kino.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    List<Movies> findMoviesByActorsIn(Set<Actors> actor);
    List<Movies> findMoviesByGenresIn(Set<Genres> genres);
}
