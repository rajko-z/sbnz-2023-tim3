package com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="izdati_lekovi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IzdatLek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private OpisLeka opisLeka;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pregled pregled;

    @Column
    private String opisDoze;

}
