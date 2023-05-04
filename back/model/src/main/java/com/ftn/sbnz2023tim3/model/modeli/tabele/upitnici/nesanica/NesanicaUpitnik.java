package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.nesanica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="nesanica_upitnici")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NesanicaUpitnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaVremenskaStavka prva;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaTrajanjeStavka druga;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaDaNeStavka treca;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaDaNeStavka cetvrta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaDaNeStavka peta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaDaNeStavka sesta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaDaNeStavka sedma;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaVremenskaStavka osma;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaDaNeStavka deveta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NesanicaDaNeStavka deseta;

    public NesanicaUpitnik(NesanicaVremenskaStavka prva, NesanicaTrajanjeStavka druga, NesanicaDaNeStavka treca, NesanicaDaNeStavka cetvrta, NesanicaDaNeStavka peta, NesanicaDaNeStavka sesta, NesanicaDaNeStavka sedma, NesanicaVremenskaStavka osma, NesanicaDaNeStavka deveta, NesanicaDaNeStavka deseta) {
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
