package com.app.quizrecall.service;

import com.app.quizrecall.model.Paper;
import com.app.quizrecall.model.Question;
import com.app.quizrecall.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Question createQuestion(Question question) {
        try {
            log.info("Creating question with number: " + question.getNumber());
            return questionRepository.save(question);
        } catch (Exception e) {
            log.error("Error occurred while creating question with number: " + question.getNumber());
            log.error(e);
            return null;
        }
    }

    public List<Question> getAllQuestions() {
        try {
            return questionRepository.findAll();
        } catch (Exception e) {
            log.error("Error with getting all questions");
            log.error(e);
            return null;
        }
    }

    public Question getQuestionById(int questionId) {
        try {
            log.info("Getting question with ID: " + questionId);
            return questionRepository.findById(questionId).get();
        } catch (Exception e) {
            log.error("Error occurred while getting question with ID: " + questionId);
            log.error(e);
            return null;
        }
    }

    public List<Question> getQuestionsByPaper(Paper paper) {
        try {
            log.info("Getting questions for paper with ID: " + paper.getId());
            return questionRepository.findByPaper(paper);
        } catch (Exception e) {
            log.error("Error occurred while getting question for paper with ID: " + paper.getId());
            log.error(e);
            return null;
        }
    }
}
