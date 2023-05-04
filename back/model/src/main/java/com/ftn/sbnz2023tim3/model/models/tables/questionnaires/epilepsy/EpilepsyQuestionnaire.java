package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.epilepsy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="epilepsy_questionnaires")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpilepsyQuestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyYesNoEntry firstQ;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyFrequencyEntry secondQ;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyTimeEntry thirdQ;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyTimeEntry fourthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyTimeEntry fifthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyTimeEntry sixthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyTimeEntry seventhQ;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyYesNoEntry eighthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyYesNoEntry ninthQ;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsyTimeEntry tenthQ;
}
