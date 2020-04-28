package com.project.kino.services.impl;

import com.project.kino.entities.Actors;
import com.project.kino.entities.Genres;
import com.project.kino.entities.Movies;
import com.project.kino.repositories.ActorsRepository;
import com.project.kino.repositories.GenresRepository;
import com.project.kino.repositories.MoviesRepository;
import com.project.kino.repositories.UserRepository;
import com.project.kino.services.ActorsService;
import com.project.kino.services.GenresService;
import com.project.kino.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsServiceImpl implements ActorsService {

    @Autowired
    private ActorsRepository actorsRepository;

    public List<Actors> getAllActors() {
        return actorsRepository.findAll();
    }
}
