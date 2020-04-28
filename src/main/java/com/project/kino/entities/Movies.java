package com.project.kino.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_movies")
public class Movies extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Actors> actors;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Genres> genres;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Reviews> reviews;
}
