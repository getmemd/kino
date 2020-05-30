package com.project.kino.services;

import com.project.kino.entities.Actors;
import com.project.kino.entities.Genres;
import com.project.kino.entities.Movies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MoviesService {
    List<Movies> getAllMovies();

    Movies getMovieById(Long id);

    void saveMovie(Movies movie);

    void deleteMovie(Movies movie);

    List<Movies> getMoviesWhereGenre(Set<Genres> genre);

    List<Movies> getMoviesWhereActor(Set<Actors> actor);
}
