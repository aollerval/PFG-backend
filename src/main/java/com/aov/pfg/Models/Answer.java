package com.aov.pfg.Models;

import com.aov.pfg.Common.Stages;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Answers")
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column()
    private Stages stages;

    @Column
    private String answer;

    @ManyToOne()
    @JoinColumn(name = "question")
    private Question question;

}
