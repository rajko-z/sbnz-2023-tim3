package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.epilepsija;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.DaNeOdgovor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="epilepsija_da_ne_stavke")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpilepsijaDaNeStavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DaNeOdgovor odgovor;
}
