package com.mymicro.microservice.controller;

import com.mymicro.microservice.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mymicro.microservice.service.MovieService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> listMovie(){
       return movieService.findAll();
    }
}
