package com.app.quizrecall.controller;

import com.app.quizrecall.service.ExamService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/exam")
@CrossOrigin(origins = "*")
public class ExamController {
    private final ExamService examService;

    @GetMapping("/")
    public ResponseEntity<?> getAllExams() {
        try {
            return new ResponseEntity<>(examService.getAllExams(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{examId}")
    public ResponseEntity<?> getExamById(@PathVariable int examId) {
        try {
            return new ResponseEntity<>(examService.getExamById(examId), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
