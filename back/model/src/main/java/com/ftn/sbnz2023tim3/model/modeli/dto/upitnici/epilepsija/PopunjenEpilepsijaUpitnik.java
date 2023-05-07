package com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.epilepsija;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.DaNeOdgovor;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.UcestalostOdgovor;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.VremenskiOdgovor;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PopunjenEpilepsijaUpitnik {

    @NotNull
    private DaNeOdgovor odgovor1;
    @NotNull
    private UcestalostOdgovor odgovor2;
    @NotNull
    private VremenskiOdgovor odgovor3;
    @NotNull
    private VremenskiOdgovor odgovor4;
    @NotNull
    private VremenskiOdgovor odgovor5;
    @NotNull
    private VremenskiOdgovor odgovor6;
    @NotNull
    private VremenskiOdgovor odgovor7;
    @NotNull
    private DaNeOdgovor odgovor8;
    @NotNull
    private DaNeOdgovor odgovor9;
    @NotNull
    private VremenskiOdgovor odgovor10;
}
