package com.app.quizrecall.controller;

import com.app.quizrecall.model.Exam;
import com.app.quizrecall.model.Paper;
import com.app.quizrecall.service.ExamService;
import com.app.quizrecall.service.PaperService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/paper")
@CrossOrigin(origins = "*")
public class PaperController {
    private final PaperService paperService;
    private final ExamService examService;

    @PostMapping("/")
    public ResponseEntity<?> createPaper(@RequestParam(name = "id", required = false) Integer id,
                                         @RequestParam(name = "medium") String medium,
                                         @RequestParam(name = "type") String type,
                                         @RequestParam(name = "exam") int examId,
                                         @RequestParam(name = "subject") String subject,
                                         @RequestParam(name = "year") int year,
                                         @RequestParam(name = "status") String status,
                                         @RequestParam(name = "duration") int duration) {
        try {
            Paper paper = new Paper();
            paper.setId(id);
            paper.setMedium(medium);
            paper.setType(type);
            paper.setExam(examService.getExamById(examId));
            paper.setSubject(subject);
            paper.setYear(year);
            paper.setStatus(status);
            paper.setDuration(duration);
            return new ResponseEntity<>(paperService.createPaper(paper), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{examId}")
    public ResponseEntity<?> getPapersByExam(@PathVariable int examId) {
        try {
            Exam exam = examService.getExamById(examId);
            return new ResponseEntity<>(paperService.getPapersByExam(exam), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
