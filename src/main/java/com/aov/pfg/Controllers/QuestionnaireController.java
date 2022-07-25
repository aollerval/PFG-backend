package com.aov.pfg.Controllers;

import com.aov.pfg.Models.Question;
import com.aov.pfg.Models.Questionnaire;
import com.aov.pfg.Requests.QuestionRequest;
import com.aov.pfg.Requests.QuestionnaireRequest;
import com.aov.pfg.Responses.QuestionnaireResponse;
import com.aov.pfg.Services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/questionnaire")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireController (QuestionnaireService questionnaireService){
        this.questionnaireService = questionnaireService;
    }


    @GetMapping("/{questionnaireCode}")
    public QuestionnaireResponse getQuestionnaireByCode(@PathVariable String questionnaireCode){
        QuestionnaireResponse response =  questionnaireService.getQuestionnaireByQuestionnaireCode(questionnaireCode);
        return response;
    }

    @PostMapping("/")
    public String createQuestionnaire(@RequestBody QuestionnaireRequest questionnaireRequest){

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setQuestionnaireCode(questionnaireRequest.getQuestionnaireCode());
        questionnaire.setQuestions(questionnaireRequest.getQuestionCodes());
        questionnaireService.saveQuestionnaire(questionnaire);
        System.out.println("a");
        return HttpStatus.OK.toString();
    }


}
