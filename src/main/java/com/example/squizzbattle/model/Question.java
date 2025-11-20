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
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    private int points;

    @Enumerated(EnumType.STRING)
    private Category category;
    private char correctOption;
    @ManyToOne
    private GameSession gameSession;

    public boolean isCorrect(char option){
        return option== this.correctOption;
    }

    public int calculatePoints() {
        return switch (difficultyLevel) {
            case EASY -> 10;
            case MEDIUM -> 20;
            case HARD -> 30;
        };
    }

    public enum DifficultyLevel {
        EASY, MEDIUM, HARD
    }

    public enum Category {
        SCIENCE, HISTORY, SPORTS, GEOGRAPHY, ART, TECHNOLOGY, LITERATURE
    }
}
