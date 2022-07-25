package com.aov.pfg.Responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class QuestionnaireResponse {

    @JsonProperty("questionnaireCode")
    private String questionnaireCode;
    private ArrayList<QuestionResponse> questions;

}
