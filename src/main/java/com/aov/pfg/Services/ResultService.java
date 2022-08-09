package com.aov.pfg.Services;

import com.aov.pfg.Models.Result;
import com.aov.pfg.Repositories.QuestionRepository;
import com.aov.pfg.Repositories.QuestionnaireRepository;
import com.aov.pfg.Repositories.ResultRepository;
import com.aov.pfg.Responses.ResultResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final QuestionRepository questionRepository;
    private final QuestionnaireRepository questionnaireRepository;
    private final AnswerService answerService;

    public ResultService (ResultRepository resultRepository, QuestionnaireRepository questionnaireRepository,
                          QuestionRepository questionRepository, AnswerService answerService){
        this.questionnaireRepository = questionnaireRepository;
        this.questionRepository = questionRepository;
        this.resultRepository = resultRepository;
        this.answerService = answerService;
    }

    public void save(Result result){
        resultRepository.save(result);
    }

    public ResultResponse getSpiderGraphData(String questionnaireCode){ //Add that it looks by user too.
        ArrayList<String> questionnaire = new ArrayList<>(questionnaireRepository.getQuestionnaireByQuestionnaireCode(questionnaireCode).getQuestions());
        ArrayList<Result> results = resultRepository.getResultByQuestionnaireCode((questionnaireCode));

        ArrayList<String> questionSubDimensions = new ArrayList<>();
        ArrayList<Integer> maxScores = new ArrayList<>();

        //Find all questions' dimension codes
        for (String question : questionnaire) {
            questionSubDimensions.add(questionRepository.findQuestionByQuestionCode(question).getSubDimension().toString());
        }

        for (Result result : results) {
            ArrayList<Integer> score = answerService.getScoresFromAnswers(new ArrayList<>(result.getAnswers()));

            if(maxScores.size() > 0){
                for(int i = 0; i < maxScores.size(); i++){
                    if(maxScores.get(i) < score.get(i)) maxScores.set(i, score.get(i));
                }
            }
            if(maxScores.size() == 0) maxScores = score;
        }

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setQuestionnaireCode(questionnaireCode);
        resultResponse.setSubDimensions(questionSubDimensions);
        resultResponse.setScores(maxScores);

        return resultResponse;
    }



}
