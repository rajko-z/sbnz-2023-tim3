package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.adhd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="adhd_questionnaires")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdhdQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry firstQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry secondQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry thirdQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry fourthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry fifthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry sixthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry seventhQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry eighthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry ninthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdEntry tenthQ;
}
