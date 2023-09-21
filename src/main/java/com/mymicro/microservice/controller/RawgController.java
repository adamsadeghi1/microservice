package com.mymicro.microservice.controller;

import com.mymicro.microservice.model.rawgModel.Game;
import com.mymicro.microservice.model.rawgModel.GameProcessed;
import com.mymicro.microservice.service.RawgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/rawg")
public class RawgController {

    @Autowired
    private RawgService rawgService;

    @CrossOrigin(origins = "http://localhost:5180") // this should be the address of your React-app server
    @GetMapping("/games")
    public ResponseEntity<List<GameProcessed>> getAllGames () throws ExecutionException, InterruptedException {
        var gamesFuture = rawgService.getGamesAsync("games");
        List<GameProcessed> games = gamesFuture.get();

        return new ResponseEntity<>(games, HttpStatus.OK);
    }
}
