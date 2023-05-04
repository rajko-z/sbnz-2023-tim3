package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.adhd;

import com.ftn.sbnz2023tim3.model.models.enums.TimeAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="adhd_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdhdEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private AdhdQuestion question;

    @Enumerated(EnumType.STRING)
    private TimeAnswer answer;
}
