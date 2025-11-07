package com.example.squizzbattle.service;

import com.example.squizzbattle.model.GameSession;
import com.example.squizzbattle.model.User;
import com.example.squizzbattle.repository.GameSessionRepository;
import com.example.squizzbattle.repository.PlayerSessionRepository;
import com.example.squizzbattle.repository.QuestionRepository;
import com.example.squizzbattle.utilities.GameStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameService {

    private final GameSessionRepository gameRepository;
    private final QuestionRepository questionRepository;
    private final PlayerSessionRepository playerSessionRepository;

    @Autowired
    public GameService(GameSessionRepository gameRepository,
                       QuestionRepository questionRepository,
                       PlayerSessionRepository playerSessionRepository){
        this.gameRepository = gameRepository;
        this.questionRepository= questionRepository;
        this.playerSessionRepository= playerSessionRepository;
    }

    public GameSession createGame(List<User> players){
        GameSession game= new GameSession();
        game.setPlayers(players);
        game.setStatus(GameStates.WAITING);
        game.setStartTime(LocalDateTime.now());
        return gameRepository.save(game);
    }

    public List<GameSession> getAllGames(){
        return gameRepository.findAll();
    }

    public List<GameSession> getGamesByStatus(String status){
        return gameRepository.findByStatus(status);
    }

    public void startGame(Long id){
        GameSession game= gameRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Game not found!"));
        game.setStatus(GameStates.RUNNING);
        gameRepository.save(game);

    }

    public void endGame(Long id){
        GameSession game= gameRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Game not found!"));
        game.setStatus(GameStates.FINISHED);
        game.setEndTime(LocalDateTime.now());
        gameRepository.save(game);
    }








}
