package com.ftn.sbnz2023tim3.model.modeli.tabele;

import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.IzdatLek;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.adhd.AdhdUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.alchajmer.AlchajmerUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.epilepsija.EpilepsijaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.nesanica.NesanicaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Doktor;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Pacijent;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pregledi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pregled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doktor doktor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pacijent pacijent;

    @OneToMany(mappedBy = "pregled", fetch = FetchType.LAZY)
    private List<IzdatLek> izdatiLekovi = new ArrayList<>();

    @Column
    private double adhdProcenat;

    @Column
    private double alchajmerProcenat;

    @Column
    private double nesanicaProcenat;

    @Column
    private double epilepsijaProcenat;

    @Column
    private String beleske;

    @Column
    private String zakljucak;

    @Column
    private LocalDateTime vremePocetka;

    @Column
    private int trajanjeEEGanalizeUMinutima;

    @Column(nullable = false)
    private boolean zavrsen;

    @OneToOne(fetch = FetchType.LAZY)
    private AdhdUpitnik adhdUpitnik;

    @OneToOne(fetch = FetchType.LAZY)
    private AlchajmerUpitnik alchajmerUpitnik;

    @OneToOne(fetch = FetchType.LAZY)
    private EpilepsijaUpitnik epilepsijaUpitnik;

    @OneToOne(fetch = FetchType.LAZY)
    private NesanicaUpitnik nesanicaUpitnik;
}
