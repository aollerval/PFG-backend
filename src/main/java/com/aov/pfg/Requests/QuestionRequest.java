package com.aov.pfg.Requests;

import com.aov.pfg.Common.Dimensions;
import com.aov.pfg.Common.SubDimensions;
import com.aov.pfg.Models.Answer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class QuestionRequest {

    private String questionCode;
    private Dimensions dimension;
    private SubDimensions subDimensions;
    private float weight;
    private String question;
    private List<AnswerRequest> answers;

}
