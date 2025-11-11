package com.example.squizzbattle.controller;

import com.example.squizzbattle.model.Question;
import com.example.squizzbattle.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService=questionService;
    }

    @PostMapping
    public ResponseEntity<Question> saveQuestion(
            @RequestParam Question question){
        Question question1= questionService.addQuestion(question);
        return ResponseEntity.ok(question1);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getQuestions(){
        List<Question> questions= questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/random")
    public ResponseEntity<Question> getRandomQuestion(){
        Question question= questionService.getRandomQuestion();
        return ResponseEntity.ok(question);
    }
    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long questionId){
        Optional<Question> question= questionService.getQuestionById(questionId);
        return question.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<Void> deleteQuestionById(@PathVariable Long questionId){
       questionService.deleteQuestion(questionId);
       return ResponseEntity.noContent().build();
    }






}
