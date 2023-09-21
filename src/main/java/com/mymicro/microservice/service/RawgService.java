package com.mymicro.microservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymicro.microservice.model.rawgModel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class RawgService {
    public static final String BASE_URL="https://api.rawg.io/api";
    @Value("${api.param.key}") // this value is read from application-secret.properties
    private String apiParamKey;
    private static Logger log = LoggerFactory.getLogger(RawgService.class);



    public CompletableFuture<List<GameProcessed>> getGamesAsync(String url) {
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
                            return processResult(results).getResults();
                        } catch (Exception e) {
                            throw new RuntimeException("Error parsing JSON response", e);
                        }
                    } else {
                        throw new RuntimeException("Request failed with status code: " + response.statusCode());
                    }
                });
    }

    private GameApiResponseProcessed processResult(GameApiResponse result) {
        List<GameProcessed> gameProcessedList = result.getResults().stream()
                .map(game -> {
                    List<Platform> platforms = Arrays.stream(game.getParent_platforms())
                            .map(Platforms::getPlatform)
                            .collect(Collectors.toList());

                    return new GameProcessed(
                            game.getId(),
                            game.getName(),
                            game.getBackground_image(),
                            platforms
                    );
                })
                .collect(Collectors.toList());

        return new GameApiResponseProcessed(gameProcessedList);
    }


}
