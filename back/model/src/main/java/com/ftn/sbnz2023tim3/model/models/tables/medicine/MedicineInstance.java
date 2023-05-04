package com.ftn.sbnz2023tim3.model.models.tables.medicine;

import com.ftn.sbnz2023tim3.model.models.tables.Examination;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="medicine_instances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private MedicineDescription description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Examination examination;

    @Column
    private String doseDescription;

    private boolean fitToPatient;

    private int priority;
}
