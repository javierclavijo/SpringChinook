package com.example.springtest.controllers;

import com.example.springtest.assemblers.TrackModelAssembler;
import com.example.springtest.exceptions.TrackNotFoundException;
import com.example.springtest.models.Track;
import com.example.springtest.repositories.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/track")
public class TrackController {

    private final TrackRepository repository;
    private final TrackModelAssembler assembler;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("")
    public List<Track> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @GetMapping("/{id}")
    public EntityModel<Track> one(@PathVariable("id") Integer id) throws TrackNotFoundException {
        Optional<Track> track = repository.findById(id);
        if (track.isPresent()) {
            return assembler.toModel(track.get());
        } else {
            throw new TrackNotFoundException(String.format("Track with id %d not found", id));
        }
    }
}
