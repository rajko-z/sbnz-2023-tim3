package com.ftn.sbnz2023tim3.service.kontroleri;

import com.ftn.sbnz2023tim3.model.modeli.dto.AlergijeDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.TextResponse;
import com.ftn.sbnz2023tim3.model.modeli.dto.lekovi.Lek;
import com.ftn.sbnz2023tim3.model.modeli.dto.pregled.PregledDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.pregled.RezultatPregledaDTO;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.service.servisi.LekoviServis;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/pregledi")
public class PregledKontroler {

    private final PregledServis pregledServis;
    private final LekoviServis lekoviServis;

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
        return new ResponseEntity<>(new TextResponse("Uspesno zapocet EEG pregled"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @PutMapping("zavrsi-eeg")
    public ResponseEntity<TextResponse> zavrsiEeg() {
        pregledServis.zavrsiEEG();
        return new ResponseEntity<>(new TextResponse("Uspesno je zavrsen EEG pregled"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @GetMapping("rezultati")
    public ResponseEntity<RezultatPregledaDTO> getRezultatiPregleda() {
        Pregled pregled = pregledServis.getTrenutniPregled();
        RezultatPregledaDTO retVal = pregledServis.vratiPregledSaSastojcima(pregled);
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @PutMapping("zavrsi-pregled")
    public ResponseEntity<TextResponse> zavrsiPregled() {
        pregledServis.zavrsiPregled();
        return new ResponseEntity<>(new TextResponse("Uspesno je zavrsen pregled"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @GetMapping("/doktor")
    public ResponseEntity<List<PregledDTO>> getPreglediByDoktor() {
        List<PregledDTO> pregledi = pregledServis.getPreglediByDoktor();
        return new ResponseEntity<>(pregledi, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @GetMapping("/pacijent")
    public ResponseEntity<List<PregledDTO>> getPreglediByPacijent() {
        List<PregledDTO> pregledi = pregledServis.getPreglediByPacijent();
        return new ResponseEntity<>(pregledi, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @PutMapping("/predlozi-lekove")
    public ResponseEntity<List<Lek>> predloziLekove(@RequestBody AlergijeDTO alergije) {
        List<Lek> lekovi = lekoviServis.predloziLekovePacijentu(alergije);
        return new ResponseEntity<>(lekovi, HttpStatus.OK);
    }
}
