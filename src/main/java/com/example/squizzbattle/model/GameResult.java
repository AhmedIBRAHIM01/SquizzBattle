package com.example.squizzbattle.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="game_result")
@Data
public class GameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int score;
    private int rank;
    @ManyToOne
    private User user;

    @ManyToOne
    private GameSession gameSession;
}
