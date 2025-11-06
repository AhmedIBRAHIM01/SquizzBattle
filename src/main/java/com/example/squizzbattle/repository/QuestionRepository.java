package com.example.squizzbattle.repository;

import com.example.squizzbattle.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
