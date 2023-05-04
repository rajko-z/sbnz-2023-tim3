package com.ftn.sbnz2023tim3.model.models.tables.questionnaires.epilepsy;

import com.ftn.sbnz2023tim3.model.models.enums.TimeAnswer;
import com.ftn.sbnz2023tim3.model.models.enums.YesNoAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="epilepsy_time_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpilepsyTimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TimeAnswer answer;
}
