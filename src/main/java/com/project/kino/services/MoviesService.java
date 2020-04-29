package com.project.kino.services;

import com.project.kino.entities.Movies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MoviesService {
    List<Movies> getAllMovies();

    Movies getMovieById(Long id);

    void saveMovie(Movies movie);
}
