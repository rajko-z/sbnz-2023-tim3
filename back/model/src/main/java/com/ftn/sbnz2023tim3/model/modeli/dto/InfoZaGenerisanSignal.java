package com.ftn.sbnz2023tim3.model.modeli.dto;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import lombok.*;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InfoZaGenerisanSignal {
    private boolean uzmiUObzirNesanicu;
    private boolean uzmiUObzirUpitnike;
    private List<Pair<TipBolesti, Double>> procenti;
    private Long pregled;
}
