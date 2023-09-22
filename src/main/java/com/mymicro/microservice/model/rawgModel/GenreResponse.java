package com.mymicro.microservice.model.rawgModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreResponse {
    List<Genre> results;
    public List<Genre> getResults() {
        return results;
    }

    public void setResults(List<Genre> result) {
        this.results = result;
    }
}
