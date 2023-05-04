package com.ftn.sbnz2023tim3.model.modeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrijavaDTO {

    @Email
    private String email;

    @NotBlank
    private String lozinka;
}
