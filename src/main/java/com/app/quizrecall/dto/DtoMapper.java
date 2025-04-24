package com.app.quizrecall.dto;

public interface DtoMapper <E, D> {
    E dtoToEntity(D dto);
    D entityToDto(E entity);
}
