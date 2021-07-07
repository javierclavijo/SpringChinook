package com.example.springtest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "MediaTypeId")
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "GenreId")
    private Genre genre;

    @OneToMany(mappedBy = "track")
    private List<InvoiceLine> invoiceLines;

    @ManyToMany(mappedBy = "tracks")
    private List<Playlist> playlists;

    @Column(name = "Composer", length = 220)
    private String composer;


    @Column(name = "Milliseconds")
    private Integer milliseconds;

    @Column(name = "Bytes")
    private Integer bytes;

    @Column(name = "UnitPrice", length = 10, precision = 2)
    private Double unitPrice;

}
