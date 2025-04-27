package com.app.quizrecall.dto.util;

import com.app.quizrecall.dto.mapper.AnswerDtoMapper;
import com.app.quizrecall.dto.obj.AnswerDto;
import com.app.quizrecall.model.Answer;
import com.app.quizrecall.model.Question;
import com.app.quizrecall.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnswerDtoUtil {
    private final AnswerDtoMapper answerDtoMapper;
    private final AnswerService answerService;

    public List<AnswerDto> getAnswerDtosByQuestion(Question question, boolean withMarks) {
        List<Answer> answers = answerService.getAnswersByQuestion(question);
        List<AnswerDto> answerDtos = new ArrayList<>();
        for (Answer answer : answers)
            answerDtos.add(answerDtoMapper.entityToDto(answer, withMarks));
        return answerDtos;
    }
}
