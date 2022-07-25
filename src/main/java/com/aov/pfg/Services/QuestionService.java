package com.aov.pfg.Services;

import com.aov.pfg.Responses.QuestionResponse;
import com.aov.pfg.Models.Question;
import com.aov.pfg.Repositories.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

//    private final ModelMapper modelMapper;

    @Autowired
    public QuestionService(QuestionRepository questionRepository ){
        this.questionRepository = questionRepository;
        //this.modelMapper = modelMapper;
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questions = new ArrayList<Question>(questionRepository.findAll());
        return questions;
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

    //Mapper methods

//    public QuestionResponse entityToDTO(Question question){
//        QuestionResponse questionDTO = modelMapper.map(question, QuestionResponse.class);
//        return questionDTO;
//    }
//
//    public Question dtoToEntity(QuestionResponse questionDTO){
//        Question question = modelMapper.map(questionDTO,Question.class);
//        return question;
//    }

}
