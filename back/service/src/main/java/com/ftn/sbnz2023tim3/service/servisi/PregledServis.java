package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Doktor;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Pacijent;
import com.ftn.sbnz2023tim3.service.izuzeci.BadRequestException;
import com.ftn.sbnz2023tim3.service.izuzeci.NotFoundException;
import com.ftn.sbnz2023tim3.service.repozitorijumi.PregledRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.DoktorServis;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.PacijentServis;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PregledServis {

    private final PregledRepozitorijum pregledRepozitorijum;

    private final PacijentServis pacijentServis;

    private final DoktorServis doktorServis;

    @Transactional
    public void zapocniPregledZaPacijenta(String pacijentEmail) {
        Pacijent pacijent = pacijentServis.findPacijentByEmail(pacijentEmail)
                .orElseThrow(() -> new NotFoundException("Pacijent sa emailom: " + pacijentEmail + " ne postoji"));

        if (pacijent.getTrenutniPregled() != null) {
            throw new BadRequestException("Pacijent vec ima pregled koji traje.");
        }

        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktor();
        if (doktor.getTrenutniPregled() != null) {
            throw new BadRequestException("Doktor vec ima pregled koji traje.");
        }

        Pregled pregled = new Pregled();
        pregled.setZavrsen(false);
        pregled.setVremePocetka(LocalDateTime.now());
        pregled.setPacijent(pacijent);
        pregled.setDoktor(doktor);

        pacijent.setTrenutniPregled(pregled);
        doktor.setTrenutniPregled(pregled);

        pregledRepozitorijum.save(pregled);
    }

    public void sacuvaj(Pregled pregled) {
        this.pregledRepozitorijum.save(pregled);
    }
}
