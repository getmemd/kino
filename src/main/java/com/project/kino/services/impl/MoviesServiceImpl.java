package com.project.kino.services.impl;

import com.project.kino.entities.Actors;
import com.project.kino.entities.Genres;
import com.project.kino.entities.Movies;
import com.project.kino.repositories.MoviesRepository;
import com.project.kino.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    public Movies getMovieById(Long id) {
        return moviesRepository.getOne(id);
    }

    public void saveMovie(Movies movie) {
        moviesRepository.save(movie);
    }

    public void deleteMovie(Movies movie) {
        moviesRepository.delete(movie);
    }

    public List<Movies> getMoviesWhereActor(Set<Actors> actor) {
        return moviesRepository.findMoviesByActorsIn(actor);
    }

    public List<Movies> getMoviesWhereGenre(Set<Genres> genre) {
        return moviesRepository.findMoviesByGenresIn(genre);
    }
}
