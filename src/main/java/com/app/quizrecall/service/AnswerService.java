package com.app.quizrecall.service;

import com.app.quizrecall.model.Answer;
import com.app.quizrecall.model.Question;
import com.app.quizrecall.repository.AnswerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Answer cretaeAnswer(Answer answer) {
        try {
            log.info("Creating answer");
            return answerRepository.save(answer);
        } catch (Exception e) {
            log.error("Error occurred while creating answer");
            log.error(e);
            return null;
        }
    }

    public List<Answer> createAllAnswers(List<Answer> answers) {
        try {
            log.info("Creating all answers for question with ID: " + answers.get(0).getQuestion().getId());
            return answerRepository.saveAll(answers);
        } catch (Exception e) {
            log.error("Error occurred while creating answers for question with ID: " + answers.get(0).getQuestion().getId());
            log.error(e);
            return null;
        }
    }

    public List<Answer> getAnswersByQuestion(Question question) {
        try {
            log.info("Getting answers for question with ID: " + question.getId());
            return answerRepository.findByQuestion(question);
        } catch (Exception e) {
            log.error("Error while getting answers for question with ID: " + question.getId());
            log.error(e);
            return null;
        }
    }
}
