package com.aov.pfg.Services;

import com.aov.pfg.Models.Question;
import com.aov.pfg.Repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository ){
        this.questionRepository = questionRepository;
    }

    public ArrayList<Question> getAllQuestions() {
        return new ArrayList<Question>(questionRepository.findAll());
    }

    public Question getQuestionById(Long id){
        Question question = questionRepository.getReferenceById(id);
        return question;
    }

    public Question getQuestionByCode(String code){
        return questionRepository.findQuestionByQuestionCode(code);
    }

    public void saveQuestion(Question question){
        try{
            questionRepository.save(question);
        }catch(Exception e){
            throw e;
        }
    }

}
