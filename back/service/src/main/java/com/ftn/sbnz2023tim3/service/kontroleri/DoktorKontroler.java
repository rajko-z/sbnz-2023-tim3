package com.ftn.sbnz2023tim3.service.kontroleri;

import com.ftn.sbnz2023tim3.model.modeli.dto.pregled.PregledDTO;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Doktor;
import com.ftn.sbnz2023tim3.service.izuzeci.BadRequestException;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.DoktorServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/doktori")
public class DoktorKontroler {

    private final DoktorServis doktorServis;

    private final PregledServis pregledServis;

    @PreAuthorize("hasAnyRole('ROLE_DOKTOR')")
    @GetMapping("/trenutni-pregled")
    public ResponseEntity<PregledDTO> getPregled() {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledom();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException("Trenutno nemate aktivni pregled");
        }
        PregledDTO pregledDTO = pregledServis.getPregledDTOById(doktor.getTrenutniPregled().getId());
        return new ResponseEntity<>(pregledDTO, HttpStatus.OK);
    }
}
