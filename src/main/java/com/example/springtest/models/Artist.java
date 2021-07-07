package com.example.springtest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ArtistId")
    private Integer id;

    @Column(name = "Name", length = 120)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artist")
    private List<Album> albums;
}