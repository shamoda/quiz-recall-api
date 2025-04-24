package com.app.quizrecall.service;

import com.app.quizrecall.model.Paper;
import com.app.quizrecall.repository.PaperRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class PaperService {
    private final PaperRepository paperRepository;

    public Paper createPaper(Paper paper) {
        try {
            log.info("Creating paper: " + paper.getSubject() + " - " + paper.getYear());
            return paperRepository.save(paper);
        } catch (Exception e) {
            log.error("Error occurred while creating paper: " + paper.getSubject() + " - " + paper.getYear());
            log.error(e);
            return null;
        }
    }

    public Paper getPaperById(int paperId) {
        try {
            return paperRepository.findById(paperId).get();
        } catch (Exception e) {
            log.error("Error occurred while retrieving paper with ID: " + paperId);
            log.error(e);
            return null;
        }
    }
}
