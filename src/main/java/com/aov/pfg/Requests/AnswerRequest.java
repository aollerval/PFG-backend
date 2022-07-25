package com.aov.pfg.Requests;

import com.aov.pfg.Common.Stages;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequest {
    private Stages stage;
    private String answer;
}
