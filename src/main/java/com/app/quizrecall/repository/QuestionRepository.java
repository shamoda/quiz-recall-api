package com.app.quizrecall.repository;

import com.app.quizrecall.model.Paper;
import com.app.quizrecall.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByPaper(Paper paper);
}
