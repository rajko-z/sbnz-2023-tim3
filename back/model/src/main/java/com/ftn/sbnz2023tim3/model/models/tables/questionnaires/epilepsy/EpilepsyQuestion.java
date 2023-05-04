package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.epilepsy;


import com.ftn.sbnz2023tim3.model.models.enums.EpilepsyQuestionCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="epilepsy_questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpilepsyQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    private EpilepsyQuestionCategory category;
}
