package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.alzheimer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="alzheimer_questionnaires")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlzheimerQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry firstQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry secondQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry thirdQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry fourthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry fifthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry sixthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry seventhQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry eighthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry ninthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AlzheimerEntry tenthQ;

}
