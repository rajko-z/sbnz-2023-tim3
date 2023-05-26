package com.ftn.sbnz2023tim3.service.kontroleri;

import com.ftn.sbnz2023tim3.model.modeli.dto.TextResponse;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.adhd.PopunjenAdhdUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.alchajmer.PopunjenAlchajmerUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.epilepsija.PopunjenEpilepsijaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.nesanica.PopunjenNesanicaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Doktor;
import com.ftn.sbnz2023tim3.service.izuzeci.BadRequestException;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.DoktorServis;
import com.ftn.sbnz2023tim3.service.servisi.upitnici.AdhdUpitnikServis;
import com.ftn.sbnz2023tim3.service.servisi.upitnici.AlchajmerUpitnikServis;
import com.ftn.sbnz2023tim3.service.servisi.upitnici.EpilepsijaUpitnikServis;
import com.ftn.sbnz2023tim3.service.servisi.upitnici.NesanicaUpitnikServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/upitnici")
public class UpitniciKontroler {

    private final static String NEMATE_TRENUTNI_PREGLED = "Nemate trenutni pregled";
    private final static String ADHD_UPITNIK_VEC_POPUNJEN = "Adhd upitnik je vec popunjen";
    private final static String ALCHAJMER_UPITNIK_VEC_POPUNJEN = "Alchajmer upitnik je vec popunjen";
    private final static String NESANICA_UPITNIK_VEC_POPUNJEN = "Nesanica upitnik je vec popunjen";
    private final static String EPILEPSIJA_UPITNIK_VEC_POPUNJEN = "Epilepsija upitnik je vec popunjen";
    private final static String UPITNIK_USPESNO_DODAT = "Upitnik uspesno dodat";

    private final AdhdUpitnikServis adhdUpitnikServis;
    private final AlchajmerUpitnikServis alchajmerUpitnikServis;
    private final NesanicaUpitnikServis nesanicaUpitnikServis;
    private final EpilepsijaUpitnikServis epilepsijaUpitnikServis;

    private final DoktorServis doktorServis;

    @PostMapping("/dodaj-adhd")
    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    public ResponseEntity<TextResponse> dodajAdhdUpitnik(@RequestBody @Valid PopunjenAdhdUpitnik adhdUpitnik) {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledomIUpitnicima();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException(NEMATE_TRENUTNI_PREGLED);
        }
        if (doktor.getTrenutniPregled().getAdhdUpitnik() != null) {
            throw new BadRequestException(ADHD_UPITNIK_VEC_POPUNJEN);
        }
        adhdUpitnikServis.dodaj(adhdUpitnik, doktor.getTrenutniPregled());
        return new ResponseEntity<>(new TextResponse(UPITNIK_USPESNO_DODAT), HttpStatus.OK);
    }

    @PostMapping("/dodaj-alchajmer")
    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    public ResponseEntity<TextResponse> dodajAlchajmerUpitnik(@RequestBody @Valid PopunjenAlchajmerUpitnik alchajmerUpitnik) {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledomIUpitnicima();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException(NEMATE_TRENUTNI_PREGLED);
        }
        if (doktor.getTrenutniPregled().getAlchajmerUpitnik() != null) {
            throw new BadRequestException(ALCHAJMER_UPITNIK_VEC_POPUNJEN);
        }
        alchajmerUpitnikServis.dodaj(alchajmerUpitnik, doktor.getTrenutniPregled());
        return new ResponseEntity<>(new TextResponse(UPITNIK_USPESNO_DODAT), HttpStatus.OK);
    }

    @PostMapping("/dodaj-nesanica")
    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    public ResponseEntity<TextResponse> dodajNesanicaUpitnik(@RequestBody @Valid PopunjenNesanicaUpitnik nesanicaUpitnik) {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledomIUpitnicima();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException(NEMATE_TRENUTNI_PREGLED);
        }
        if (doktor.getTrenutniPregled().getNesanicaUpitnik() != null) {
            throw new BadRequestException(NESANICA_UPITNIK_VEC_POPUNJEN);
        }
        nesanicaUpitnikServis.dodaj(nesanicaUpitnik, doktor.getTrenutniPregled());
        return new ResponseEntity<>(new TextResponse(UPITNIK_USPESNO_DODAT), HttpStatus.OK);
    }

    @PostMapping("/dodaj-epilepsija")
    @PreAuthorize("hasRole('ROLE_DOKTOR')")
    public ResponseEntity<TextResponse> dodajEpilepsijaUpitnik(@RequestBody @Valid PopunjenEpilepsijaUpitnik epilepsijaUpitnik) {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledomIUpitnicima();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException(NEMATE_TRENUTNI_PREGLED);
        }
        if (doktor.getTrenutniPregled().getEpilepsijaUpitnik() != null) {
            throw new BadRequestException(EPILEPSIJA_UPITNIK_VEC_POPUNJEN);
        }
        epilepsijaUpitnikServis.dodaj(epilepsijaUpitnik, doktor.getTrenutniPregled());
        return new ResponseEntity<>(new TextResponse(UPITNIK_USPESNO_DODAT), HttpStatus.OK);
    }

}
