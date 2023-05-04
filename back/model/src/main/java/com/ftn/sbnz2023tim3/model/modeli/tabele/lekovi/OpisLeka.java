package com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.Uzrast;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="opisi_lekova")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpisLeka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String naziv;

    @Column(nullable = false)
    private boolean zaBlaguBolest;

    @Column(nullable = false)
    private boolean zaSrednjuBolest;

    @Column(nullable = false)
    private boolean zaTeskuBolest;

    @ElementCollection(targetClass = Uzrast.class, fetch = FetchType.EAGER)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<Uzrast> dozvoljeniUzrasti;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "opis_leka_id")
    private List<SastojakLeka> sastojci;

    @Enumerated(EnumType.STRING)
    private TipBolesti tipBolesti;
}
