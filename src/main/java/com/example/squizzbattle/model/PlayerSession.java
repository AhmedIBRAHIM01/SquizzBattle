package com.example.squizzbattle.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "player_session")
@Data
public class PlayerSession {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long sessionId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    private GameSession gameSession;
    private int currentScore;



}
