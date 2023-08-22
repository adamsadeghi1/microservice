package com.mymicro.microservice.controller;

import com.mymicro.microservice.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mymicro.microservice.service.MovieService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MovieController {
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Movie> listMovie(){
       return movieService.findAll();
    }

    @PostMapping(value = "new/movie")
    public ResponseEntity<Movie> create(@RequestBody Movie movie){
        var changedMovie = movieService.addMovie(movie);
        return  ResponseEntity.ok().body(changedMovie);
    }

    @DeleteMapping(value = "del/{id}")
    public ResponseEntity deleteMovie(@PathVariable String id){
        long longId = Long.valueOf(id);
        var movieName = movieService.delete(longId);
        return ResponseEntity.ok().body(String.format( "Delete process completed successfully for Movie: %s",movieName));
    }
}
