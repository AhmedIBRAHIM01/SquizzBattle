package com.example.squizzbattle.service;

import com.example.squizzbattle.model.GameSession;
import com.example.squizzbattle.repository.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameSessionService {

    private GameSessionRepository gameSessionRepository;

    @Autowired
    public GameSessionService(GameSessionRepository gameSessionRepository){
        this.gameSessionRepository= gameSessionRepository;
    }




}
