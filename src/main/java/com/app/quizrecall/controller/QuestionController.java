package com.app.quizrecall.controller;

import com.app.quizrecall.dto.util.QuestionDtoUtil;
import com.app.quizrecall.model.Paper;
import com.app.quizrecall.model.Question;
import com.app.quizrecall.service.PaperService;
import com.app.quizrecall.service.QuestionService;
import com.app.quizrecall.util.Base64Util;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/question")
@CrossOrigin(origins = "*")
public class QuestionController {
    private final QuestionService questionService;
    private final Base64Util base64Util;
    private final PaperService paperService;
    private final QuestionDtoUtil questionDtoUtil;

    @PostMapping("/")
    public ResponseEntity<?> createQuestion(@RequestParam(name = "id", required = false) Integer id,
                                            @RequestParam(name = "number") int number,
                                            @RequestParam(name = "description") String description,
                                            @RequestParam(name = "type") String type,
                                            @RequestParam(name = "category") String category,
                                            @RequestParam(name = "paperId") int paperId) {
        try {
            Question question = new Question();
            question.setId(id);
            question.setNumber(number);
            question.setDescription(description);
            question.setType(type);
            question.setCategory(category);
            question.setPaper(paperService.getPaperById(paperId));
            return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * parameter2 should be either AA== (false) or AQ== (true)
     */
    @PostMapping("/paper")
    @Operation(summary = "Both parameters should be base64 encoded.", description = "parameter1 is for paperId and parameter2 is withMarks flag. parameter2 should be either AA== (false) or AQ== (true). reason is to avoid url bypassing")
    public ResponseEntity<?> getQuestionsAndAnswersByPaper(@RequestParam(name = "parameter1") String parameter1,
                                                           @RequestParam(name = "parameter2") String parameter2) {
        try {
            int paperId = base64Util.decodeInteger(parameter1);
            log.info("Decoded " + parameter1 + " to paper ID: " + paperId);
            boolean withMarks = base64Util.decodeBoolean(parameter2);
            log.info("Decoded " + parameter2 + " to with marks: " + withMarks);

            Paper paper = paperService.getPaperById(paperId);
            return new ResponseEntity<>(questionDtoUtil.getQuestionDtosByPaper(paper, withMarks), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
