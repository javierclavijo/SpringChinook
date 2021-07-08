package com.example.springtest.controllers;

import com.example.springtest.exceptions.Error;
import com.example.springtest.exceptions.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<Error> getTrackNotFoundException(Exception e) {
        return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
