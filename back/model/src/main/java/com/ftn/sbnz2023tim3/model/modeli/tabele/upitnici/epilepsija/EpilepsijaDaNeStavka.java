package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.epilepsija;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.DaNeOdgovor;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="epilepsija_da_ne_stavke")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpilepsijaDaNeStavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DaNeOdgovor odgovor;

    @ManyToOne(fetch = FetchType.EAGER)
    private EpilepsijaPitanje pitanje;

    public EpilepsijaDaNeStavka(DaNeOdgovor odgovor, EpilepsijaPitanje pitanje) {
        this.odgovor = odgovor;
        this.pitanje = pitanje;
    }

    public double getVrednost() {
        return odgovor.getValue() * pitanje.getKategorija().getValue();
    }

    @Transient
    private Pregled pregled;
}
