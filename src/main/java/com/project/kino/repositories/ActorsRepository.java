package com.project.kino.repositories;

import com.project.kino.entities.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {

}
