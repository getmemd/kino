package com.project.kino.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_actors")
public class Actors extends BaseEntity {
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "photo")
    private String photo;
}
