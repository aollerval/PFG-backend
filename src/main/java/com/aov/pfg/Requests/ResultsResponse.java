package com.aov.pfg.Requests;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;

@Getter
@Setter
public class ResultsResponse {

    private String resultCode; //Placeholder for user response
    private String questionnaireCode;
    private ArrayList<String> answers;
}
