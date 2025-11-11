package com.example.squizzbattle.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name= "game_session")
@Data

public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private GameStates status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToMany
    private List<User> players;
    @OneToMany(mappedBy="gameSession")
    private List<PlayerSession> playerSessions;
    @OneToMany(mappedBy = "gameSession")
    private List<Question> questions;



}
