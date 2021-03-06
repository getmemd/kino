package com.project.kino.services;

import com.project.kino.entities.Genres;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenresService {
    List<Genres> getAllGenres();

    Genres getGenreById(Long id);

    void saveGenre(Genres genre);

    void deleteGenre(Genres genre);
}
