package com.ftn.sbnz2023tim3.model.models.tables.medicine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="medicine_ingredients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}
