package com.ftn.sbnz2023tim3.model.modeli.dto.pregled;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RezultatPregledaDTO {

    private double adhdProcenat;
    private double alchajmerProcenat;
    private double nesanicaProcenat;
    private double epilepsijaProcenat;


    // ukoliko je neki od procenata veci od 50, inace polje nece biti popunjeno
    private TipBolesti tipBolesti;
    private double procenatPronadjeneBolesti;

    // ukoliko postoji neka bolest ponuditi sve sastojke popularnih lekova da cekira
    // na sta je alergican
    private List<String> sastojci;

}
