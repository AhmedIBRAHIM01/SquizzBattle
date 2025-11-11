package com.example.squizzbattle.repository;

import com.example.squizzbattle.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    public List<Question> findByCategory(Question.Category category);
}
