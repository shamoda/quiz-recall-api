package com.app.quizrecall.dto.obj;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Data
public class QuestionDto {
    private Integer id;
    private int number;
    private String description;
    private String type;
    private String category;
    private Integer paperId;
    private List<AnswerDto> answers;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdated;
}
