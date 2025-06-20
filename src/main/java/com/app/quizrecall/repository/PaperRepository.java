package com.app.quizrecall.repository;

import com.app.quizrecall.model.Exam;
import com.app.quizrecall.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Integer> {
    List<Paper> findByExam(Exam exam);
}
