package com.aov.pfg.Repositories;

import com.aov.pfg.Common.Dimensions;
import com.aov.pfg.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    public Question findQuestionByQuestionCode(String questionCode);
    public List<Question> findQuestionsByDimension(Dimensions dimension);
}
