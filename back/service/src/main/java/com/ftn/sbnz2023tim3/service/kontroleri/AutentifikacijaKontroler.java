package com.ftn.sbnz2023tim3.service.kontroleri;

import com.ftn.sbnz2023tim3.model.modeli.dto.KorisnikSaTokenom;
import com.ftn.sbnz2023tim3.model.modeli.dto.PrijavaDTO;
import com.ftn.sbnz2023tim3.service.servisi.AutentifikacijaServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/auth")
public class AutentifikacijaKontroler {

    private final AutentifikacijaServis autentifikacijaServis;

    @PostMapping("/login")
    public ResponseEntity<KorisnikSaTokenom> createAuthenticationToken(@RequestBody @Valid PrijavaDTO prijavaDTO) {
        KorisnikSaTokenom userWithToken = autentifikacijaServis.kreirajAutentifikacioniToken(prijavaDTO);
        return new ResponseEntity<>(userWithToken, HttpStatus.OK);
    }
}
