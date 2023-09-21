package com.mymicro.microservice.model.rawgModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mymicro.microservice.model.rawgModel.Game;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameApiResponse {
    private List<Game> results;

    public List<Game> getResults() {
        return results;
    }

    public void setResults(List<Game> results) {
        this.results = results;
    }
}