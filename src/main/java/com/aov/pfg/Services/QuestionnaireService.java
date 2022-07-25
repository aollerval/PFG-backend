package com.aov.pfg.Services;

import com.aov.pfg.Models.Answer;
import com.aov.pfg.Responses.AnswerResponse;
import com.aov.pfg.Responses.QuestionResponse;
import com.aov.pfg.Models.Question;
import com.aov.pfg.Models.Questionnaire;
import com.aov.pfg.Repositories.QuestionnaireRepository;
import com.aov.pfg.Responses.QuestionnaireResponse;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionService questionService;
    private final AnswerService answerService;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository, QuestionService questionService, AnswerService answerService){
        this.questionnaireRepository = questionnaireRepository;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    public void saveQuestionnaire(Questionnaire questionnaire){
        questionnaireRepository.save(questionnaire);
    }

    public QuestionnaireResponse getQuestionnaireByQuestionnaireCode(String code){

        Questionnaire questionnaire = questionnaireRepository.getQuestionnaireByQuestionnaireCode(code);
        ArrayList<QuestionResponse> questionResponses = new ArrayList<>();
        QuestionnaireResponse finalQuestionnaire = new QuestionnaireResponse();

        for (String question: questionnaire.getQuestions()) {

            Question transientQuestion = questionService.getQuestionByCode(question);
            ArrayList<Answer> answers = answerService.getQuestionAnswers(transientQuestion);
            ArrayList<AnswerResponse> answerResponses = new ArrayList<>();

            for (Answer answer: transientQuestion.getAnswers()) {
                //Creo el response de cada answer
                AnswerResponse answerResponse = new AnswerResponse();
                answerResponse.setId(answer.getId());
                answerResponse.setAnswer(answer.getAnswer());
                answerResponses.add(answerResponse);
            }

            //Creo el response de Question
            QuestionResponse questionResponse = new QuestionResponse();
            questionResponse.setQuestionCode(transientQuestion.getQuestionCode());
            questionResponse.setQuestion(transientQuestion.getQuestion());
            questionResponse.setAnswers(answerResponses); //Agrego los answer responses a su question
            questionResponses.add(questionResponse); //Agrego el question al questionnaire
            finalQuestionnaire.setQuestions(questionResponses);
            finalQuestionnaire.setQuestionnaireCode(questionnaire.getQuestionnaireCode());
        }
        return finalQuestionnaire;
    }
}
