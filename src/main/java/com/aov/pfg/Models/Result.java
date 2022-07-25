package com.aov.pfg.Models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Result")
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String resultCode; //Placeholder for user response

    @Column
    private String questionnaireCode;

    @Column()
    @ElementCollection
    private List<String> answers;

}
