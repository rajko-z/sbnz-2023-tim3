package com.ftn.sbnz2023tim3.model.models.tables.medicine;

import com.ftn.sbnz2023tim3.model.models.enums.Age;
import com.ftn.sbnz2023tim3.model.models.enums.DiseaseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="medicine_descriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean mildIllness;

    @Column(nullable = false)
    private boolean middleIllness;

    @Column(nullable = false)
    private boolean severeIllness;

    @ElementCollection(targetClass = Age.class, fetch = FetchType.EAGER)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<Age> allowedAges;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_description_id")
    private List<MedicineIngredient> ingredients;

    @Enumerated(EnumType.STRING)
    private DiseaseType diseaseType;
}
