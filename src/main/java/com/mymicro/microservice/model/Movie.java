package com.mymicro.microservice.model;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name ;
    @Column(nullable = true)
    private String author ;
    @Column(nullable = true)
    private LocalDate publishedDate ;

    public Movie( String name, String author, LocalDate publishedDate) {
        this.name = name;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
