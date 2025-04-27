package com.app.quizrecall.dto.util;

import com.app.quizrecall.dto.mapper.QuestionDtoMapper;
import com.app.quizrecall.dto.obj.AnswerDto;
import com.app.quizrecall.dto.obj.QuestionDto;
import com.app.quizrecall.model.Paper;
import com.app.quizrecall.model.Question;
import com.app.quizrecall.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionDtoUtil {
    private final QuestionDtoMapper questionDtoMapper;
    private final QuestionService questionService;
    private final AnswerDtoUtil answerDtoUtil;

    public List<QuestionDto> getQuestionDtosByPaper(Paper paper, boolean withMarks) {
        List<Question> questions = questionService.getQuestionsByPaper(paper);
        List<QuestionDto> questionDtos = new ArrayList<>();

        for (Question question : questions) {
            QuestionDto questionDto = questionDtoMapper.entityToDto(question);
            List<AnswerDto> answerDtos = answerDtoUtil.getAnswerDtosByQuestion(question, withMarks);
            questionDto.setAnswers(answerDtos);
            questionDtos.add(questionDto);
        }
        return questionDtos;
    }
}
