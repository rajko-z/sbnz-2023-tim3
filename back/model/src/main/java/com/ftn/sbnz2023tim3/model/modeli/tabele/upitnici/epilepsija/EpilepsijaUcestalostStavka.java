package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.epilepsija;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.UcestalostOdgovor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="epilepsija_ucestalost_stavke")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpilepsijaUcestalostStavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UcestalostOdgovor odgovor;
}