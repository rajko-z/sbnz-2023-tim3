package com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.adhd;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori.VremenskiOdgovor;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PopunjenAdhdUpitnik {
    @NotNull
    private VremenskiOdgovor odgovor1;
    @NotNull
    private VremenskiOdgovor odgovor2;
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
    private VremenskiOdgovor odgovor8;
    @NotNull
    private VremenskiOdgovor odgovor9;
    @NotNull
    private VremenskiOdgovor odgovor10;
}
