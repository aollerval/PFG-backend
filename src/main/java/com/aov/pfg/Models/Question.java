package com.aov.pfg.Models;

import com.aov.pfg.Common.Dimensions;
import com.aov.pfg.Common.SubDimensions;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Questions")
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String questionCode;

    @Enumerated(EnumType.STRING)
    @Column()
    private Dimensions dimension;

    @Enumerated(EnumType.STRING)
    @Column()
    private SubDimensions subDimension;

    @Column()
    private float weight;

    @Column()
    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;


}
