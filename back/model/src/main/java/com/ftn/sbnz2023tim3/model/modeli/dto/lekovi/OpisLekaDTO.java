package com.ftn.sbnz2023tim3.model.modeli.dto.lekovi;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.Uzrast;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OpisLekaDTO {
    private String naziv;
    private boolean zaBlaguBolest;
    private boolean zaSrednjuBolest;
    private boolean zaTeskuBolest;
    private List<Uzrast> dozvoljeniUzrasti;
    private List<String> sastojci;
    private TipBolesti tipBolesti;
}
