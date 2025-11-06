package com.example.squizzbattle.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "questions")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char correctOption;
    @ManyToOne
    private GameSession gameSession;

    public boolean isCorrect(char option){
        return option== this.correctOption;
    }
}
