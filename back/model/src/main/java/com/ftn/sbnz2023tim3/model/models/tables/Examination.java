package com.ftn.sbnz2023tim3.model.models.tables;

import com.ftn.sbnz2023tim3.model.models.tables.medicine.MedicineInstance;
import com.ftn.sbnz2023tim3.model.models.tables.questionnaires.adhd.AdhdQuestionnaire;
import com.ftn.sbnz2023tim3.model.models.tables.questionnaires.alzheimer.AlzheimerQuestionnaire;
import com.ftn.sbnz2023tim3.model.models.tables.questionnaires.epilepsy.EpilepsyQuestionnaire;
import com.ftn.sbnz2023tim3.model.models.tables.questionnaires.insomnia.InsomniaQuestionnaire;
import com.ftn.sbnz2023tim3.model.models.tables.users.Doctor;
import com.ftn.sbnz2023tim3.model.models.tables.users.Patient;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="examinations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @OneToMany(mappedBy = "examination", fetch = FetchType.LAZY)
    private List<MedicineInstance> medicines = new ArrayList<>();

    @Column
    private double adhdPercentage;

    @Column
    private double alzheimerPercentage;

    @Column
    private double insomniaPercentage;

    @Column
    private double epilepsyPercentage;

    @Column
    private String notes;

    @Column
    private String conclusion;

    @Column
    private LocalDateTime startTime;

    @Column
    private int eegAnalysisDurationInMinutes;

    @Column(nullable = false)
    private boolean finished;

    @OneToOne(fetch = FetchType.LAZY)
    private AdhdQuestionnaire adhdQuestionnaire;

    @OneToOne(fetch = FetchType.LAZY)
    private AlzheimerQuestionnaire alzheimerQuestionnaire;

    @OneToOne(fetch = FetchType.LAZY)
    private EpilepsyQuestionnaire epilepsyQuestionnaire;

    @OneToOne(fetch = FetchType.LAZY)
    private InsomniaQuestionnaire insomniaQuestionnaire;
}
