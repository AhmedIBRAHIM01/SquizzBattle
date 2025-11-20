package com.example.squizzbattle.repository;

import com.example.squizzbattle.model.GameSession;
import com.example.squizzbattle.model.GameStates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
    List<GameSession> findByStatus(GameStates status);
}
