package com.mymicro.microservice.service;

import com.mymicro.microservice.model.Movie;
import org.springframework.stereotype.Service;
import com.mymicro.microservice.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }


}
