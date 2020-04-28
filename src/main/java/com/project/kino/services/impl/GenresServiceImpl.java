package com.project.kino.services.impl;

import com.project.kino.entities.Genres;
import com.project.kino.entities.Movies;
import com.project.kino.repositories.GenresRepository;
import com.project.kino.repositories.MoviesRepository;
import com.project.kino.repositories.UserRepository;
import com.project.kino.services.GenresService;
import com.project.kino.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresServiceImpl implements GenresService {

    @Autowired
    private GenresRepository genresRepository;

    public List<Genres> getAllGenres() {
        return genresRepository.findAll();
    }
}