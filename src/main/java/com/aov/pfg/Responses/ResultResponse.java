package com.aov.pfg.Responses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultResponse {

    private String questionnaireCode;
    private ArrayList<String> subDimensions;
    private ArrayList<Integer> scores;

}
