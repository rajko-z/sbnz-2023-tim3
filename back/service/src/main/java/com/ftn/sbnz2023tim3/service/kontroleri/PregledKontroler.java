package com.ftn.sbnz2023tim3.service.kontroleri;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;
import com.ftn.sbnz2023tim3.model.modeli.dto.TextResponse;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import com.ftn.sbnz2023tim3.service.servisi.signali.SignalServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/pregledi")
public class PregledKontroler {

    private final PregledServis pregledServis;

    private final SignalServis signalServis;

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @PostMapping("/zapocni/{pacijentEmail}")
    public ResponseEntity<TextResponse> zapocniPregledZaPacijenta(@PathVariable String pacijentEmail) {
        pregledServis.zapocniPregledZaPacijenta(pacijentEmail);
        return new ResponseEntity<>(new TextResponse("Uspesno zapocet pregled za pacijenta"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @PutMapping("/zapocni-eeg")
    public ResponseEntity<TextResponse> zapocniEeg() {
        pregledServis.zapocniEEG();
        return new ResponseEntity<>(new TextResponse("Uspesno zapocet eeg pregled"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @GetMapping("/generisi-signal")
    public ResponseEntity<GenerisanSignal> generisiSignal() {
        GenerisanSignal signal = signalServis.generisiEegSignal();
        return new ResponseEntity<>(signal, HttpStatus.OK);
    }

}
