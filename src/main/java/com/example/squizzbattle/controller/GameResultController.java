package com.example.squizzbattle.controller;


import com.example.squizzbattle.model.GameResult;
import com.example.squizzbattle.service.GameResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins="*")
public class GameResultController {

    private final GameResultService gameResultService;

     @Autowired
    public GameResultController(GameResultService gameResultService){
        this.gameResultService= gameResultService;
    }

    // Save new game results
    @PostMapping
    public ResponseEntity<GameResult> saveResult(
            @RequestParam Long userId,
            @RequestParam Long gameId,
            @RequestParam int score,
            @RequestParam int rank

    ){
         GameResult result= gameResultService.saveResult(userId,gameId,score,rank);
         return ResponseEntity.ok(result);

    }

@GetMapping("/game/{gameId}")
    public ResponseEntity<List<GameResult>> getGameResultById(@PathVariable Long gameId){

         List<GameResult> gameResults= gameResultService.getResultsByGame(gameId);
         return ResponseEntity.ok(gameResults);
}

@GetMapping("/user/{userId}")
    public ResponseEntity<List<GameResult>> getPlayerResultById(@PathVariable Long userId){
         List<GameResult> playerResult= gameResultService.getResultsByUser(userId);
         return ResponseEntity.ok(playerResult);
}

    // GET – Ranking eines Spiels (nach Score)
    @GetMapping("/game/{gameId}/ranking")
    public ResponseEntity<List<GameResult>> getRanking(@PathVariable Long gameId) {
        List<GameResult> ranking = gameResultService.getRankingForGame(gameId);
        return ResponseEntity.ok(ranking);
    }

    // GET – Bestes Ergebnis eines Users

    @GetMapping("/user/{userId}/best")
    public ResponseEntity<Object> getBestResult(@PathVariable Long userId) {
        Optional<GameResult> result = gameResultService.getBestResultForUser(userId);
        return ResponseEntity.ok(result);
    }

   // DELETE – Ergebnisse eines Spiels löschen

    @DeleteMapping("/game/{gameId}")
    public ResponseEntity<Void> deleteResults(@PathVariable Long gameId) {
        gameResultService.deleteResultsByGame(gameId);
        return ResponseEntity.noContent().build();
    }

}
