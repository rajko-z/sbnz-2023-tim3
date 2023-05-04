package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.adhd;

import com.ftn.sbnz2023tim3.model.models.enums.AdhdQuestionCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="adhd_questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdhdQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    private AdhdQuestionCategory category;
}
