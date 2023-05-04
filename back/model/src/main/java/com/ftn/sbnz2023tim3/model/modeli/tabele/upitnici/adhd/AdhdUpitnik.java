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

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka prva;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka druga;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka treca;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka cetvrta;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka peta;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka sesta;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka sedma;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka osma;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka deveta;

    @OneToOne(fetch = FetchType.EAGER)
    private AdhdStavka deseta;
}
