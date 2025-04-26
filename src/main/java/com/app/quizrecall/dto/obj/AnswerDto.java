package com.app.quizrecall.dto.obj;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Data
public class AnswerDto {
    private Integer id;
    private String description;
    private boolean isCorrect;
    private float marks;
    private Integer questionId;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdated;
}
