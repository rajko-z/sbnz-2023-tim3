package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.epilepsija;

import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaDaNeStavka prva;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaUcestalostStavka druga;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaVremenskaStavka treca;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaVremenskaStavka cetvrta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaVremenskaStavka peta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaVremenskaStavka sesta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaVremenskaStavka sedma;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaDaNeStavka osma;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaDaNeStavka deveta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EpilepsijaVremenskaStavka deseta;

    public EpilepsijaUpitnik(EpilepsijaDaNeStavka prva, EpilepsijaUcestalostStavka druga, EpilepsijaVremenskaStavka treca, EpilepsijaVremenskaStavka cetvrta, EpilepsijaVremenskaStavka peta, EpilepsijaVremenskaStavka sesta, EpilepsijaVremenskaStavka sedma, EpilepsijaDaNeStavka osma, EpilepsijaDaNeStavka deveta, EpilepsijaVremenskaStavka deseta) {
        this.prva = prva;
        this.druga = druga;
        this.treca = treca;
        this.cetvrta = cetvrta;
        this.peta = peta;
        this.sesta = sesta;
        this.sedma = sedma;
        this.osma = osma;
        this.deveta = deveta;
        this.deseta = deseta;
    }
}
