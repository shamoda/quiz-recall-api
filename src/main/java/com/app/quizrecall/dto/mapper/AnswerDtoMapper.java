package com.app.quizrecall.dto.mapper;

import com.app.quizrecall.dto.DtoMapper;
import com.app.quizrecall.dto.obj.AnswerDto;
import com.app.quizrecall.model.Answer;
import org.springframework.stereotype.Service;

@Service
public class AnswerDtoMapper implements DtoMapper<Answer, AnswerDto> {
    @Override
    public Answer dtoToEntity(AnswerDto dto) {
        return null;
    }

    @Override
    public AnswerDto entityToDto(Answer entity) {
        AnswerDto dto = new AnswerDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setQuestionId(entity.getQuestion().getId());
        dto.setCorrect(entity.isCorrect());
        dto.setMarks(entity.getMarks());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastUpdated(entity.getLastUpdated());
        return dto;
    }

    public AnswerDto entityToDto(Answer entity, boolean withMarks) {
        AnswerDto dto = new AnswerDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setQuestionId(entity.getQuestion().getId());
        if (withMarks) {
            dto.setCorrect(entity.isCorrect());
            dto.setMarks(entity.getMarks());
        }
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastUpdated(entity.getLastUpdated());
        return dto;
    }
}
