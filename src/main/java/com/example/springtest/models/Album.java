package com.example.springtest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AlbumId")
    private Integer id;

    @Column(name = "Title", length = 160)
    private String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId", nullable = false)
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private List<Track> tracks;

}
