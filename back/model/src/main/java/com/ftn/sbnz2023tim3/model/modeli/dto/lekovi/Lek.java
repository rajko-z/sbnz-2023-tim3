package com.ftn.sbnz2023tim3.model.modeli.dto.lekovi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.Uzrast;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.*;

import javax.persistence.Transient;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(value= {"pregled"})
public class Lek {
    private String naziv;
    private boolean zaBlaguBolest;
    private boolean zaSrednjuBolest;
    private boolean zaTeskuBolest;
    private List<Uzrast> dozvoljeniUzrasti;
    private List<String> sastojci;
    private TipBolesti tipBolesti;

    @Transient
    private Pregled pregled;
    private String opisDoze;

    @Transient
    private int prioritet;
}
