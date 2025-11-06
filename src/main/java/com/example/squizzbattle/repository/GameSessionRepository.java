package com.example.squizzbattle.repository;

import com.example.squizzbattle.model.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
    List<GameSession> findByStatus(String status);
}
