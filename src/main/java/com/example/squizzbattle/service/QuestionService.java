package com.example.squizzbattle.service;


import com.example.squizzbattle.model.Question;
import com.example.squizzbattle.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository= questionRepository;
    }

    public List<Question> getAllQuestions(){
       return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Long id){
        return questionRepository.findById(id);
    }

    public void deleteQuestion(Long id){
        questionRepository.deleteById(id);
    }

    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }

    public Question getRandomQuestion(){
        List<Question> questions= questionRepository.findAll();
        if (questions.isEmpty()) {

            throw new RuntimeException("No questions found!");
        }

        return questions.get((int)(Math.random()* questions.size()));
    }


}
