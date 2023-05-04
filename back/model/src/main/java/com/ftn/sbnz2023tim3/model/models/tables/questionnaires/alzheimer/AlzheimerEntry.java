package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.alzheimer;


import com.ftn.sbnz2023tim3.model.models.enums.TimeAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="alzheimer_time_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlzheimerEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TimeAnswer answer;
}
