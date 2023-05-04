package com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="sastojci")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SastojakLeka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

}
