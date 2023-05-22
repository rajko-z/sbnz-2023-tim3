package com.ftn.sbnz2023tim3.model.modeli.dto;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RezultatSignala {

    private Long pregledId;
    private TipSignala tip;
    private double brojPovisenih;
    private double brojSmanjenih;
    private double brojNormalnih;
    private double ukupanBroj;
}
