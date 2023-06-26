package com.ftn.sbnz.device.model.dto;

import com.ftn.sbnz.device.model.enumeracije.TipBolesti;
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
