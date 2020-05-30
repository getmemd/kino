package com.project.kino.services;

import com.project.kino.entities.Actors;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorsService {
    List<Actors> getAllActors();

    Actors getActorById(Long id);

    void saveActor(Actors actor);

    void deleteActor(Actors actor);
}
