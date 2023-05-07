package com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.nesanica;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.DaNeOdgovor;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.TrajanjeOdgovor;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.VremenskiOdgovor;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PopunjenNesanicaUpitnik {
    @NotNull
    private VremenskiOdgovor odgovor1;
    @NotNull
    private TrajanjeOdgovor odgovor2;
    @NotNull
    private DaNeOdgovor odgovor3;
    @NotNull
    private DaNeOdgovor odgovor4;
    @NotNull
    private DaNeOdgovor odgovor5;
    @NotNull
    private DaNeOdgovor odgovor6;
    @NotNull
    private DaNeOdgovor odgovor7;
    @NotNull
    private VremenskiOdgovor odgovor8;
    @NotNull
    private DaNeOdgovor odgovor9;
    @NotNull
    private DaNeOdgovor odgovor10;
}
