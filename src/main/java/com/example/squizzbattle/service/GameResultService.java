package com.example.squizzbattle.service;

import com.example.squizzbattle.model.GameResult;
import com.example.squizzbattle.model.GameSession;
import com.example.squizzbattle.model.User;
import com.example.squizzbattle.repository.GameResultRepository;
import com.example.squizzbattle.repository.GameSessionRepository;
import com.example.squizzbattle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameResultService {
    private final GameResultRepository gameResultRepository;
    private final GameSessionRepository gameSessionRepository;
    private final UserRepository userRepository;

    @Autowired
    public GameResultService(GameResultRepository gameResultRepository,
                             GameSessionRepository gameSessionRepository,
                             UserRepository userRepository) {
        this.gameResultRepository = gameResultRepository;
        this.gameSessionRepository = gameSessionRepository;
        this.userRepository = userRepository;
    }

    public GameResult saveResult(Long userId, Long gameId, int score, int rank){
        User user= userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("No such player found!"));
        GameSession game= gameSessionRepository.findById(gameId)
                .orElseThrow(()->new RuntimeException("No such game found!"));

     GameResult gameResult= new GameResult();
     gameResult.setUser(user);
     gameResult.setGameSession(game);
     gameResult.setRank(rank);
     gameResult.setScore(score);
     return gameResult;
    }

    public List<GameResult> getResultsByGame(Long id){
        return gameResultRepository.findAll()
                .stream()
                .filter(gameResult -> gameResult.getGameSession().getId()==id)
                .toList();

    }
    public List<GameResult> getResultsByUser(Long userId){
       return gameResultRepository.findAll()
                .stream()
                .filter(gameResult ->  gameResult.getUser().getId()==userId)
                .toList();

    }
    /**
     * Holt das Ranking (sortiert nach Score) für ein bestimmtes Spiel.
     */
    public List<GameResult> getRankingForGame(Long id){
        return getResultsByGame(id)
                .stream()
                .sorted(Comparator.comparingInt(GameResult::getScore).reversed())
                .collect(Collectors.toList());
    }

    public Optional<GameResult> getBestResultForUser(Long id){
        return getResultsByUser(id)
                .stream()
                .max(Comparator.comparingInt(GameResult::getScore));
    }

    public void deleteResultsByGame(Long gameId) {
        List<GameResult> results = getResultsByGame(gameId);
        gameResultRepository.deleteAll(results);
    }
}
