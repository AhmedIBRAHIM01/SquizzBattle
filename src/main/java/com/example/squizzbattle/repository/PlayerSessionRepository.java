package com.example.squizzbattle.repository;

import com.example.squizzbattle.model.PlayerSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerSessionRepository extends JpaRepository<PlayerSession, Long> {
}
