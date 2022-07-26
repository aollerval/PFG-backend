package com.aov.pfg.Services;

import com.aov.pfg.Common.Stages;
import com.aov.pfg.Models.Answer;
import com.aov.pfg.Models.Question;
import com.aov.pfg.Repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    public AnswerService(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    private final AnswerRepository answerRepository;

    public ArrayList<Answer> getQuestionAnswers(Question question){
        return answerRepository.findByQuestion(question);
    }

    public void saveAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public ArrayList<Integer> getScoresFromAnswers(ArrayList<Integer> answers){
        ArrayList<Integer> scores = new ArrayList<>();

        for (Integer i : answers) {
            Answer answer = answerRepository.findAnswerById(Long.valueOf(i));
            Stages stage = answer.getStages();
            scores.add(stage.getValue());
        }

        return scores;
    }
}
