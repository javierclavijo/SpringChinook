package com.example.springtest.controllers;

import com.example.springtest.models.Playlist;
import com.example.springtest.repositories.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/playlist")
public class PlaylistController {

    private final PlaylistRepository repository;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("")
    public List<Playlist> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @GetMapping("/{id}")
    public Optional<Playlist> one(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

}
