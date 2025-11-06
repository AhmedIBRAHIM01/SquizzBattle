package com.example.squizzbattle.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name= "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String passwordHash;
    private int totalScore;
    @OneToMany(mappedBy = "user")
    private List<PlayerSession> sessions;
    @ManyToMany(mappedBy = "players")
    private List<GameSession> games;

}
