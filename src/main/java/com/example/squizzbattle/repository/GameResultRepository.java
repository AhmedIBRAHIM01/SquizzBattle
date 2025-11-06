package com.example.squizzbattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.squizzbattle.model.GameReslut;

public interface GameResultRepository extends JpaRepository<GameReslut, Long> {
}
