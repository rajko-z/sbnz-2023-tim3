package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.alzheimer;

import com.ftn.sbnz2023tim3.model.models.enums.AlzheimerQuestionCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="alzheimer_questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlzheimerQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    private AlzheimerQuestionCategory category;
}
