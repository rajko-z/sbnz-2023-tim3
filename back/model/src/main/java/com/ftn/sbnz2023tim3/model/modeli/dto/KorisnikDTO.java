package com.ftn.sbnz2023tim3.model.modeli.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class KorisnikDTO {

    @Email
    private String email;

    @NotBlank
    private String ime;

    @NotBlank
    private String prezime;
    private int brojGodina;
    private String brojTelefona;
    private String adresa;
    private String rola;
}
