package com.mymicro.microservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymicro.microservice.model.rawgModel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    public CompletableFuture<List<Genre>> getGenresAsync(String url){
        log.info("Reading Data from {} end-point",url );
        String fullUrl = BASE_URL + "/" + url + apiParamKey ;
        CompletableFuture<GenreResponse> response =  getAsync(fullUrl, GenreResponse.class);
        return response.thenApply( res -> res.getResults());
    }

    public CompletableFuture<List<GameProcessed>>  getGamesAsync(String url, String genresParamValue){
        log.info("Reading Data from {} end-point",url );
        String fullUrl = BASE_URL + "/" + url + apiParamKey +"&page=1" +(genresParamValue!= null? "&genres="+genresParamValue:"");

        CompletableFuture<GameApiResponse> response =  getAsync(fullUrl, GameApiResponse.class);
        return response.thenApply( res -> processGameResult(res).getResults());
    }


    private <TResponse> CompletableFuture<TResponse> getAsync(String fullUrl, Class<TResponse> responseType) {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() == 200) {
                        try {
                            ObjectMapper objectMapper = new ObjectMapper();
                            return objectMapper.readValue(response.body(), responseType);
                        } catch (Exception e) {
                            throw new RuntimeException("Error parsing JSON response", e);
                        }
                    } else {
                        throw new RuntimeException("Request failed with status code: " + response.statusCode());
                    }
                });
    }

    private GameApiResponseProcessed processGameResult(GameApiResponse result) {
        List<GameProcessed> gameProcessedList = result.getResults().stream()
                .map(game -> {
                    List<Platform> platforms = Arrays.stream(game.getParent_platforms())
                            .map(Platforms::getPlatform)
                            .collect(Collectors.toList());

                    return new GameProcessed(
                            game.getId(),
                            game.getName(),
                            game.getBackground_image(),
                            platforms,
                            game.getMetacritic()
                    );
                })
                .collect(Collectors.toList());

        return new GameApiResponseProcessed(gameProcessedList);
    }


}
