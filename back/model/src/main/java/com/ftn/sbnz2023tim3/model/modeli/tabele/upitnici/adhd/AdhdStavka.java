package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.adhd;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.VremenskiOdgovor;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="adhd_stavke")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdhdStavka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private AdhdPitanje pitanje;

    @Enumerated(EnumType.STRING)
    private VremenskiOdgovor odgovor;

    @Transient
    private Pregled pregled;

    public AdhdStavka(AdhdPitanje pitanje, VremenskiOdgovor odgovor) {
        this.pitanje = pitanje;
        this.odgovor = odgovor;
    }

    public double getVrednost() {
        return odgovor.getValue() * pitanje.getKategorija().getValue();
    }
}
