package com.ftn.sbnz2023tim3.model.modeli.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class KorisnikSaTokenom {

    @NotNull
    private KorisnikDTO korisnik;

    @NotBlank
    private String token;
}
