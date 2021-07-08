package com.example.springtest.controllers;

import com.example.springtest.models.Album;
import com.example.springtest.repositories.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/album")
public class AlbumController {

    private final AlbumRepository repository;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("")
    public List<Album> all(
            @RequestParam(value = "artist") Optional<String> artistName
    ) {
        if (artistName.isPresent()) {
            return repository.findAllByArtistName(artistName.get());
        } else {
            return repository.findAll();
        }
    }
    // end::get-aggregate-root[]

    @GetMapping("/{id}")
    public Optional<Album> one(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

}
