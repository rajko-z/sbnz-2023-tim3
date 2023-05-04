package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.insomnia;

import com.ftn.sbnz2023tim3.model.models.enums.DurationAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="insomnia_duration_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsomniaDurationEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DurationAnswer answer;
}
