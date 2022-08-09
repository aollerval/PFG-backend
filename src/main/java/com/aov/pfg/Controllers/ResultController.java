package com.aov.pfg.Controllers;

import com.aov.pfg.Models.Result;
import com.aov.pfg.Requests.ResultsRequest;
import com.aov.pfg.Responses.ResultResponse;
import com.aov.pfg.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/result")
@CrossOrigin(origins = "http://localhost:3000")
public class ResultController {

    private ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService){
        this.resultService = resultService;
    }

    @PostMapping("/")
    public void gatherResults(@RequestBody ResultsRequest resultsRequest){
        Result result = new Result();
        result.setResultCode(resultsRequest.getResultCode());
        result.setQuestionnaireCode(resultsRequest.getQuestionnaireCode());
        result.setAnswers(resultsRequest.getAnswers());

        resultService.save(result);
    }

    @GetMapping("/{questionnaireCode}")
    public ResultResponse sendResultsForGraph(@PathVariable String questionnaireCode){
        return resultService.getSpiderGraphData(questionnaireCode);
    }


}
