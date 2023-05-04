package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.adhd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="adhd_upitnici")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdhdUpitnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka prva;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka druga;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka treca;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka cetvrta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka peta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka sesta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka sedma;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka osma;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka deveta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AdhdStavka deseta;

    public AdhdUpitnik(AdhdStavka prva, AdhdStavka druga, AdhdStavka treca, AdhdStavka cetvrta, AdhdStavka peta, AdhdStavka sesta, AdhdStavka sedma, AdhdStavka osma, AdhdStavka deveta, AdhdStavka deseta) {
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
