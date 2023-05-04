package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.alchajmer;


import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.VremenskiOdgovor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="alchajmer_stavke")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlchajmerStavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VremenskiOdgovor odgovor;
}