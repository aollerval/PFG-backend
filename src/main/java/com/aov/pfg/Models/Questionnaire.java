package com.aov.pfg.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Questionnaire")
@Getter
@Setter
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "questionnaireCode")
    private String questionnaireCode;

    @Column(name = "questions")
    @ElementCollection
    private List<String> questions;
}
