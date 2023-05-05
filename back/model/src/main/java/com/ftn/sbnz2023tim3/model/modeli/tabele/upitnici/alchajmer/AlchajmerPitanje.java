package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.alchajmer;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.kategorije.AlchajmerKategorijaPitanja;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="alchajmer_pitanja")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlchajmerPitanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pitanje;

    @Column(nullable = false)
    private int redniBroj;

    @Enumerated(EnumType.STRING)
    private AlchajmerKategorijaPitanja kategorija;
}
