package com.example.squizzbattle.service;

import com.example.squizzbattle.model.PlayerSession;
import com.example.squizzbattle.repository.PlayerSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerSessionService {

    private final PlayerSessionRepository playerSessionRepository;

    @Autowired
    public PlayerSessionService(PlayerSessionRepository playerSessionRepository){
        this.playerSessionRepository= playerSessionRepository;
    }

    public PlayerSession save(PlayerSession playerSession){
        return playerSessionRepository.save(playerSession);
    }

    public List<PlayerSession> getBuyUser(Long id){
        return playerSessionRepository.findAll()
                .stream()
                .filter(playerSession -> playerSession.getUser().getId()==id)
                .toList();
    }
}
