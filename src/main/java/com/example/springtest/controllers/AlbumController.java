package com.example.springtest.controllers;

import com.example.springtest.models.Album;
import com.example.springtest.repositories.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
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
    public Album one(@PathVariable("id") Integer id) {
        try {
            Optional<Album> album = repository.findById(id);
            if (album.isEmpty()) {
                throw new NoSuchElementException();
            } else {
                return album.get();
            }
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Album not found");
        }
    }
}
