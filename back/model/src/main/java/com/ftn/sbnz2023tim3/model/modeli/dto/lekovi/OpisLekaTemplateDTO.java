package com.ftn.sbnz2023tim3.model.modeli.dto.lekovi;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.Uzrast;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class OpisLekaTemplateDTO {
    public String naziv;
    public Uzrast uzrast;
    public String opisDoze;
}
