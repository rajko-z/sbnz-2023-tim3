package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.epilepsija;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="epilepsija_upitnici")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpilepsijaUpitnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaDaNeStavka prva;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaUcestalostStavka druga;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaVremenskaStavka treca;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaVremenskaStavka cetvrta;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaVremenskaStavka peta;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaVremenskaStavka sesta;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaVremenskaStavka sedma;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaDaNeStavka osma;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaDaNeStavka deveta;

    @OneToOne(fetch = FetchType.EAGER)
    private EpilepsijaVremenskaStavka deseta;
}
