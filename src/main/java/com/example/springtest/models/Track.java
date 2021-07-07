package com.example.springtest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TrackId")
    private Integer id;

    @Column(name = "Name", length = 200)
    private String name;

    @ManyToOne
    @JoinColumn(name = "AlbumId")
    private Album album;

}
