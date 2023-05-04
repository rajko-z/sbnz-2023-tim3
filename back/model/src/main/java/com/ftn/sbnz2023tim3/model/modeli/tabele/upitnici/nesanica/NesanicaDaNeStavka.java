package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.nesanica;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.DaNeOdgovor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="nesanica_da_ne_stavke")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NesanicaDaNeStavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DaNeOdgovor odgovor;
}
