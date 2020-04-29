package com.project.kino.services.impl;

import com.project.kino.entities.Movies;
import com.project.kino.repositories.MoviesRepository;
import com.project.kino.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
