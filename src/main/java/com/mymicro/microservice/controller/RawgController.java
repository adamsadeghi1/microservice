package com.mymicro.microservice.controller;

import com.mymicro.microservice.model.rawgModel.*;
import com.mymicro.microservice.service.RawgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/rawg")
public class RawgController {

    @Autowired
    private RawgService rawgService;

    @CrossOrigin(origins = "http://localhost:5180") // this should be the address of your React-app server
    @GetMapping("/games")
    public ResponseEntity<List<GameProcessed>> getAllGames (@RequestParam(name = "genres", required = false) String genresParamValue,
                                                            @RequestParam(name = "platforms", required = false) String platformParamValue,
                                                            @RequestParam(name = "ordering",required = false) String orderingParamValue) throws ExecutionException, InterruptedException {
        var gamesFuture = rawgService.getGamesAsync("games", genresParamValue, platformParamValue, orderingParamValue);
        List<GameProcessed> games = gamesFuture.get();

        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:5180") // this should be the address of your React-app server
    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres () throws ExecutionException, InterruptedException {
        var genresFuture = rawgService.getGenresAsync("genres");
        List<Genre> genres = genresFuture.get();

        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:5180") // this should be the address of your React-app server
    @GetMapping("/platforms")
    public ResponseEntity<List<Platform>> getParentPlatforms () throws ExecutionException, InterruptedException {
        var genresFuture = rawgService.getParentPlatformAsync("platforms/lists/parents");
        List<Platform> genres = genresFuture.get();

        return new ResponseEntity<>(genres, HttpStatus.OK);
    }


}
