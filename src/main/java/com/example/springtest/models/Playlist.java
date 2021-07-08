package com.example.springtest.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Playlist")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PlaylistId")
    private Integer id;

    @Column(name = "Name", length = 120)
    private String name;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToMany
    @JoinTable(
            name = "PlaylistTrack",
            joinColumns = @JoinColumn(name = "PlaylistId", referencedColumnName = "PlaylistId"),
            inverseJoinColumns = @JoinColumn(name = "TrackId", referencedColumnName = "TrackId")
    )
    private List<Track> tracks;

}
