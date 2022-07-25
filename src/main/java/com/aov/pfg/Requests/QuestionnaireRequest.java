package com.aov.pfg.Requests;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class QuestionnaireRequest {

    private String questionnaireCode;
    private ArrayList<String> questionCodes;

}
