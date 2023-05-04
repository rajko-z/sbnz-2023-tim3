package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.insomnia;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="insomnia_questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsomniaQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;
}
