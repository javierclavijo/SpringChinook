package com.example.springtest.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.springtest.controllers.TrackController;
import com.example.springtest.models.Track;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class TrackModelAssembler implements RepresentationModelAssembler<Track, EntityModel<Track>> {

    @Override
    public EntityModel<Track> toModel(Track track) {
        return EntityModel.of(track,
                linkTo(methodOn(TrackController.class).one(track.getId())).withSelfRel(),
                linkTo(methodOn(TrackController.class).all()).withRel("tracks")
        );
    }
}
