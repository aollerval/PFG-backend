package com.aov.pfg.Controllers;

import com.aov.pfg.Models.Answer;
import com.aov.pfg.Models.Question;
import com.aov.pfg.Requests.AnswerRequest;
import com.aov.pfg.Requests.QuestionRequest;
import com.aov.pfg.Services.AnswerService;
import com.aov.pfg.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {

    private QuestionService questionService;

    private AnswerService answerService;

    @Autowired
    public QuestionController(QuestionService questionService, AnswerService answerService){
        this.questionService = questionService;
        this.answerService = answerService;
    }




    @GetMapping("/")
    public ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = questionService.getAllQuestions();
        return questions;
    }

    @GetMapping("/{questionCode}")
    public Question getQuestionByCode(@PathVariable String questionCode){

        //questionService.getQuestionByCode();
        return null;
    }

    @GetMapping("/{Dimension}")
    public ArrayList<Question> getQuestionsByDimension(){

        return null;
    }

    @PostMapping("/")
    public void createQuestions(@RequestBody QuestionRequest questionRequest){
        try {

            Question question = new Question();
            question.setQuestionCode(questionRequest.getQuestionCode());
            question.setDimension(questionRequest.getDimension());
            question.setSubDimension(questionRequest.getSubDimensions());
            question.setWeight(questionRequest.getWeight());
            question.setQuestion(questionRequest.getQuestion());

            questionService.saveQuestion(question);

            for (AnswerRequest answer: questionRequest.getAnswers()){
                Answer transientAnswer = new Answer();
                transientAnswer.setStages(answer.getStage());
                transientAnswer.setAnswer(answer.getAnswer());
                transientAnswer.setQuestion(question);
                answerService.saveAnswer(transientAnswer);
            }

        }catch (Exception e){
            throw e;
        }
    }
}
