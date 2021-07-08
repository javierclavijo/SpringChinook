package com.example.springtest.repositories;

import com.example.springtest.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findAllByArtistName(String artistName);
}