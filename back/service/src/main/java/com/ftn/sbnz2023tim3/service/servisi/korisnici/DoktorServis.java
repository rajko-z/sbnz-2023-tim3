package com.ftn.sbnz2023tim3.service.servisi.korisnici;

import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Doktor;
import com.ftn.sbnz2023tim3.service.izuzeci.NotFoundException;
import com.ftn.sbnz2023tim3.service.repozitorijumi.DoktorRepozitorijum;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoktorServis {

    private final DoktorRepozitorijum doktorRepozitorijum;

    public boolean doktorVecImaPregledUToku() {
        Doktor doktor = getTrenutnoUlogovanDoktor();
        return doktor.getTrenutniPregled() != null;
    }

    public Doktor getTrenutnoUlogovanDoktor() {
        String doktorEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return doktorRepozitorijum.findById(doktorEmail)
                .orElseThrow(() -> new NotFoundException("Korisnik sa mejlom nije poznat: " + doktorEmail));
    }


    public Doktor getTrenutnoUlogovanDoktorSaPregledomIUpitnicima() {
        String doktorEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return doktorRepozitorijum.findByEmailWithPregledAndUpitnici(doktorEmail)
                .orElseThrow(() -> new NotFoundException("Korisnik sa mejlom nije poznat: " + doktorEmail));
    }

    public Doktor getTrenutnoUlogovanDoktorSaPregledom() {
        String doktorEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return doktorRepozitorijum.findByEmailWithPregled(doktorEmail)
                .orElseThrow(() -> new NotFoundException("Korisnik sa mejlom nije poznat: " + doktorEmail));
    }

    public Doktor getTrenutnoUlogovanDoktorSaPregledomIIstorijomPregleda() {
        String doktorEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return doktorRepozitorijum.findByEmailWithPregledAndPregledHistory(doktorEmail)
                .orElseThrow(() -> new NotFoundException("Korisnik sa mejlom nije poznat: " + doktorEmail));
    }


    public void sacuvaj(Doktor doktor) {
        this.doktorRepozitorijum.save(doktor);
    }
}
