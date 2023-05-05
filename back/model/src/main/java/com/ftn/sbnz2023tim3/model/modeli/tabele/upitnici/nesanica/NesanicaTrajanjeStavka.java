package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.nesanica;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.TrajanjeOdgovor;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="nesanica_trajanje_stavke")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NesanicaTrajanjeStavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TrajanjeOdgovor odgovor;

    @ManyToOne(fetch = FetchType.EAGER)
    private NesanicaPitanje pitanje;

    public NesanicaTrajanjeStavka(TrajanjeOdgovor odgovor, NesanicaPitanje pitanje) {
        this.odgovor = odgovor;
        this.pitanje = pitanje;
    }

    @Transient
    private Pregled pregled;
}
