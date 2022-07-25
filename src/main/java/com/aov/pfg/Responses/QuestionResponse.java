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
public class QuestionResponse {
    private String questionCode;
    private String question;
    private ArrayList<AnswerResponse> answers;
}
