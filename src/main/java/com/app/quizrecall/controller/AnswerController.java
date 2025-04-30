package com.app.quizrecall.controller;

import com.app.quizrecall.model.Answer;
import com.app.quizrecall.model.Question;
import com.app.quizrecall.service.AnswerService;
import com.app.quizrecall.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/answer")
@CrossOrigin(origins = "*")
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;

    @PostMapping("/")
    public ResponseEntity<?> createAnswer(@RequestParam(name = "id", required = false) Integer id,
                                          @RequestParam(name = "description") String description,
                                          @RequestParam(name = "isCorrect") boolean isCorrect,
                                          @RequestParam(name = "marks") float marks,
                                          @RequestParam(name = "questionId") int questionId) {
        try {
            Answer answer = new Answer();
            answer.setId(id);
            answer.setDescription(description);
            answer.setCorrect(isCorrect);
            answer.setMarks(marks);
            answer.setQuestion(questionService.getQuestionById(questionId));
            return new ResponseEntity<>(answerService.cretaeAnswer(answer), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
