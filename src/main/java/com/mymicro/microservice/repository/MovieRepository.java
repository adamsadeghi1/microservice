package com.mymicro.microservice.repository;

import com.mymicro.microservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}

