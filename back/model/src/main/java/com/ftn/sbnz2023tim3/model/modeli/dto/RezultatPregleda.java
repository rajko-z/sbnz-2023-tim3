package com.ftn.sbnz2023tim3.model.modeli.dto;


import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RezultatPregleda {
    private double procenatEpilepsije;
    private double procenatNesanice;
    private double procenatAlchajmera;
    private double procenatADHD;
    private Pregled pregled;
}
