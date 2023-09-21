package com.mymicro.microservice.model.rawgModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameApiResponseProcessed {
    private List<GameProcessed> results;

    public GameApiResponseProcessed(List<GameProcessed> results) {
        this.results = results;
    }

    public GameApiResponseProcessed(){}

    public List<GameProcessed> getResults() {
        return results;
    }

    public void setResults(List<GameProcessed> results) {
        this.results = results;
    }
}