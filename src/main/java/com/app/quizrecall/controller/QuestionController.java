package com.app.quizrecall.controller;

import com.app.quizrecall.model.Paper;
import com.app.quizrecall.model.Question;
import com.app.quizrecall.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/question")
@CrossOrigin(origins = "*")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/")
    public ResponseEntity<?> createQuestion(@RequestParam(name = "id", required = false) Integer id,
                                            @RequestParam(name = "number") int number,
                                            @RequestParam(name = "description") String description,
                                            @RequestParam(name = "type") String type,
                                            @RequestParam(name = "category") String category,
                                            @RequestParam(name = "paper") Paper paper) {
        try {
            Question question = new Question();
            question.setId(id);
            question.setNumber(number);
            question.setDescription(description);
            question.setType(type);
            question.setCategory(category);
            question.setPaper(paper);
            return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
