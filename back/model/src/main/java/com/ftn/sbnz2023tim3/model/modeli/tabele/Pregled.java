package com.ftn.sbnz2023tim3.model.modeli.tabele;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ftn.sbnz2023tim3.model.modeli.dto.lekovi.Lek;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjeEEGPregleda;
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

    @OneToMany(mappedBy = "pregled", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column
    private LocalDateTime eegVremePocetka;

    @Column
    private LocalDateTime eegVremeZavrsetka;

    @Column(nullable = false)
    private boolean zavrsen;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AdhdUpitnik adhdUpitnik;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AlchajmerUpitnik alchajmerUpitnik;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private EpilepsijaUpitnik epilepsijaUpitnik;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private NesanicaUpitnik nesanicaUpitnik;

    @Enumerated(EnumType.STRING)
    private StanjeEEGPregleda stanjeEEGPregleda;

    @Transient
    private List<Lek> predlozeniLekovi = new ArrayList<>();

    public boolean zdravRezultat() {
        return adhdProcenat <= 0.5 && alchajmerProcenat <= 0.5 && epilepsijaProcenat <= 0.5 && nesanicaProcenat <= 0.5;
    }
}
