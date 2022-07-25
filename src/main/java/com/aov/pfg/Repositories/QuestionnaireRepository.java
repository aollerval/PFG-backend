package com.aov.pfg.Repositories;

import com.aov.pfg.Models.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
    public Questionnaire getQuestionnaireByQuestionnaireCode(String code);
}
