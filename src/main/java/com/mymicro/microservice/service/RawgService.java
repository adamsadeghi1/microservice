package com.mymicro.microservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymicro.microservice.model.Game;
import com.mymicro.microservice.model.GameApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class RawgService {
    public static final String BASE_URL="https://api.rawg.io/api";
    @Value("${api.param.key}")
    private String apiParamKey;
    private static Logger log = LoggerFactory.getLogger(RawgService.class);



    public CompletableFuture<List<Game>> getGamesAsync(String url) {
        String fullUrl = BASE_URL + "/" + url + apiParamKey +"&page=1";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() == 200) {
                        try {
                            ObjectMapper objectMapper = new ObjectMapper();
                            var results=objectMapper.readValue(response.body(), new TypeReference<GameApiResponse>() {});
                            return results.getResults();
                        } catch (Exception e) {
                            throw new RuntimeException("Error parsing JSON response", e);
                        }
                    } else {
                        throw new RuntimeException("Request failed with status code: " + response.statusCode());
                    }
                });
    }


}
