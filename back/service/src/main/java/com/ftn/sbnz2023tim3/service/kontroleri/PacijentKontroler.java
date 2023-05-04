package com.ftn.sbnz2023tim3.service.kontroleri;

import com.ftn.sbnz2023tim3.model.modeli.dto.KorisnikDTO;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.PacijentServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/pacijenti")
public class PacijentKontroler {

    private final PacijentServis pacijentServis;

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @GetMapping
    public ResponseEntity<List<KorisnikDTO>> getAllPacijente() {
        List<KorisnikDTO> pacijenti = pacijentServis.findAllPacijente();
        return new ResponseEntity<>(pacijenti, HttpStatus.OK);
    }
}
