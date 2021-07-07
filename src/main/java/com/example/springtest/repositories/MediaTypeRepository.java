package com.example.springtest.repositories;

import com.example.springtest.models.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaTypeRepository extends JpaRepository<MediaType, Integer> {
}