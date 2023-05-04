package com.ftn.sbnz2023tim3.service.kontroleri;

import com.ftn.sbnz2023tim3.model.modeli.dto.KorisnikDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.NoviPacijentDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.TextResponse;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.PacijentServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    @PostMapping
    public ResponseEntity<TextResponse> addPacijent(@RequestBody @Valid NoviPacijentDTO pacijent) {
        pacijentServis.addPacijent(pacijent);
        return new ResponseEntity<>(new TextResponse("Pacijent uspesno dodat"), HttpStatus.OK);
    }
}
