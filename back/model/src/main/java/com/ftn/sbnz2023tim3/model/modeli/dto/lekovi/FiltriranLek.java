package com.ftn.sbnz2023tim3.model.modeli.dto.lekovi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FiltriranLek {

    private Pregled pregled;

    private Lek lek;
}
