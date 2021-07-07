package com.example.springtest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GenreId")
    private Integer id;

    @Column(name = "Name", length = 120)
    private String name;

}
