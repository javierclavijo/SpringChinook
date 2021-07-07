package com.example.springtest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PlaylistId")
    private Integer id;

    @Column(name = "Name", length = 120)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "PlaylistTrack",
            joinColumns = @JoinColumn(name = "PlaylistId", referencedColumnName = "PlaylistId"),
            inverseJoinColumns = @JoinColumn(name = "TrackId", referencedColumnName = "TrackId")
    )
    private List<Track> tracks;

}
