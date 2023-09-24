package com.mymicro.microservice.model.rawgModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformResponse {
    List<Platform> results;

    public List<Platform> getResults() {
        return results;
    }

    public void setResults(List<Platform> results) {
        this.results = results;
    }
}
