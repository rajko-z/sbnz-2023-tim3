package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.nesanica;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="nesanica_pitanja")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NesanicaPitanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int redniBroj;

    @Column(nullable = false)
    private String pitanje;
}
