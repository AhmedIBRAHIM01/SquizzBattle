package com.example.squizzbattle.controller;

import com.example.squizzbattle.model.GameSession;
import com.example.squizzbattle.model.User;
import com.example.squizzbattle.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Games")
@CrossOrigin(origins = "*")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    //post methods

    @PostMapping("/create")
    public ResponseEntity<GameSession> createGame(@RequestParam List<User> players) {
        GameSession newGame = gameService.createGame(players);
        return ResponseEntity.ok(newGame);
    }

// get Methods

    @GetMapping
    public ResponseEntity<List<GameSession>> getGameSessions() {
        List<GameSession> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<GameSession>> getGamesByStatus(@PathVariable String status) {
        List<GameSession> games = gameService.getGamesByStatus(status);
        return ResponseEntity.ok(games);
    }

    //put methods

    @PutMapping("/{gameId}/start")
    public ResponseEntity<Void> startGame(@PathVariable Long gameId) {
        gameService.startGame(gameId);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{gameId}/end")
    public ResponseEntity<Void> endGame(@PathVariable Long gameId){
        gameService.endGame(gameId);
        return ResponseEntity.noContent().build();
    }






}
