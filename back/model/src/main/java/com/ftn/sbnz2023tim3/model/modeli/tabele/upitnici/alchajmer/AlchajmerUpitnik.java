package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.alchajmer;

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
    
    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka prva;

    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka druga;

    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka treca;

    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka cetvrta;

    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka peta;

    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka sesta;

    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka sedma;

    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka osma;

    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka deveta;

    @OneToOne(fetch = FetchType.EAGER)
    private AlchajmerStavka deseta;

}
