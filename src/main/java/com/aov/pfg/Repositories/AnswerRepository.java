package com.aov.pfg.Repositories;

import com.aov.pfg.Models.Answer;
import com.aov.pfg.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    public ArrayList<Answer> findByQuestion(Question question);
    public Answer findAnswerById(Long Id);
}
