package com.aov.pfg.Requests;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultsRequest implements Serializable {

    private String resultCode; //Placeholder for user response
    private String questionnaireCode;
    private ArrayList<String> questionCodes;
    private ArrayList<Integer> answers;
}
