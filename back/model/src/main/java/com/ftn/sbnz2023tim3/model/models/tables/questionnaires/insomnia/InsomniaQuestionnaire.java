package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.insomnia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="insomnia_questionnaires")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsomniaQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaTimeEntry firstQ;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaDurationEntry secondQ;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaYesNoEntry thirdQ;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaYesNoEntry fourthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaYesNoEntry fifthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaYesNoEntry sixthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaYesNoEntry seventhQ;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaTimeEntry eighthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaYesNoEntry ninthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private InsomniaYesNoEntry tenthQ;
}
