package com.mymicro.microservice.service;

import com.mymicro.microservice.model.Movie;
import org.springframework.stereotype.Service;
import com.mymicro.microservice.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public String delete (long id){
        Optional<Movie> find = findById(id);
        if (find.isEmpty())
            return  "No Movie";

        movieRepository.deleteById(id);
        return find.get().getName();
    }

    public Optional<Movie> findById(long id){
        return movieRepository.findById(id);
    }


}
