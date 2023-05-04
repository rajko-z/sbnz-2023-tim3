package com.ftn.sbnz2023tim3.service.kontroleri;

import com.ftn.sbnz2023tim3.model.modeli.dto.TextResponse;
import com.ftn.sbnz2023tim3.service.repozitorijumi.PregledRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/pregledi")
public class PregledKontroler {


    private final PregledServis pregledServis;

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @PostMapping("/zapocni/{pacijentEmail}")
    public ResponseEntity<TextResponse> zapocniPregledZaPacijenta(@PathVariable String pacijentEmail) {
        pregledServis.zapocniPregledZaPacijenta(pacijentEmail);
        return new ResponseEntity<>(new TextResponse("Uspesno zapocet pregled za pacijenta"), HttpStatus.OK);
    }
}
