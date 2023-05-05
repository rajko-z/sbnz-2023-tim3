package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.alchajmer;

import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="alchajmer_upitnici")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlchajmerUpitnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka prva;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka druga;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka treca;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka cetvrta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka peta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka sesta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka sedma;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka osma;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka deveta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AlchajmerStavka deseta;

    public AlchajmerUpitnik(AlchajmerStavka prva, AlchajmerStavka druga, AlchajmerStavka treca, AlchajmerStavka cetvrta, AlchajmerStavka peta, AlchajmerStavka sesta, AlchajmerStavka sedma, AlchajmerStavka osma, AlchajmerStavka deveta, AlchajmerStavka deseta) {
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

    @Transient
    private Pregled pregled;
}
