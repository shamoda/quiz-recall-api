package com.app.quizrecall.dto.mapper;

import com.app.quizrecall.dto.DtoMapper;
import com.app.quizrecall.dto.obj.QuestionDto;
import com.app.quizrecall.model.Question;
import org.springframework.stereotype.Service;

@Service
public class QuestionDtoMapper implements DtoMapper<Question, QuestionDto> {
    @Override
    public Question dtoToEntity(QuestionDto dto) {
        return null;
    }

    @Override
    public QuestionDto entityToDto(Question entity) {
        QuestionDto dto = new QuestionDto();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setDescription(entity.getDescription());
        dto.setType(entity.getType());
        dto.setCategory(entity.getCategory());
        dto.setPaperId(entity.getPaper().getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastUpdated(entity.getLastUpdated());
        return dto;
    }
}
