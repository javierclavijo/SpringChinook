package com.example.springtest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MediaTypeId")
    private Integer id;

    @Column(name = "Name", length = 120)
    private String name;

    @OneToMany(mappedBy = "mediaType")
    private List<Track> tracks;

}
