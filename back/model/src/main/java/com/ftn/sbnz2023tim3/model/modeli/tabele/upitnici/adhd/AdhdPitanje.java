package com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.adhd;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.kategorije.AdhdKategorijaPitanja;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="adhd_pitanja")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdhdPitanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pitanje;

    @Column(nullable = false)
    private int redniBroj;

    @Enumerated(EnumType.STRING)
    private AdhdKategorijaPitanja kategorija;
}
