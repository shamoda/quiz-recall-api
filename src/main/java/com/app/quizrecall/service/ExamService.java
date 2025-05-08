package com.app.quizrecall.service;

import com.app.quizrecall.model.Exam;
import com.app.quizrecall.repository.ExamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class ExamService {
    private final ExamRepository examRepository;

    public List<Exam> getAllExams() {
        try {
            return examRepository.findAll();
        } catch (Exception e) {
            log.error("Error occurred while retrieving all exams");
            log.error(e);
            return null;
        }
    }

    public Exam getExamById(int examId) {
        try {
            return examRepository.findById(examId).get();
        } catch (Exception e) {
            log.error("Error occurred while retrieving exam with ID: " + examId);
            log.error(e);
            return null;
        }
    }
}
