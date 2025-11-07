package com.example.squizzbattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.squizzbattle.model.GameResult;

public interface GameResultRepository extends JpaRepository<GameResult, Long> {
}
