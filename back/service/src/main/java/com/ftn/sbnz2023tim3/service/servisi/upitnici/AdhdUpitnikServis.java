package com.ftn.sbnz2023tim3.service.servisi.upitnici;

import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.PopunjenAdhdUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.adhd.AdhdPitanje;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.adhd.AdhdStavka;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.adhd.AdhdUpitnik;
import com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.adhd.AdhdPitanjeRepozitorijum;
import com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.adhd.AdhdUpitnikRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AdhdUpitnikServis {

    private final AdhdUpitnikRepozitorijum adhdUpitnikRepozitorijum;

    private final AdhdPitanjeRepozitorijum adhdPitanjeRepozitorijum;

    private final PregledServis pregledServis;

    @Transactional
    public void dodaj(PopunjenAdhdUpitnik adhdUpitnik, Pregled trenutniPregled) {
        List<AdhdPitanje> pitanja = adhdPitanjeRepozitorijum.findAll();
        AdhdStavka prva = new AdhdStavka(pitanja.get(0), adhdUpitnik.getOdgovor1());
        AdhdStavka druga = new AdhdStavka(pitanja.get(1), adhdUpitnik.getOdgovor2());
        AdhdStavka treca = new AdhdStavka(pitanja.get(2), adhdUpitnik.getOdgovor3());
        AdhdStavka cetvrta = new AdhdStavka(pitanja.get(3), adhdUpitnik.getOdgovor4());
        AdhdStavka peta = new AdhdStavka(pitanja.get(4), adhdUpitnik.getOdgovor5());
        AdhdStavka sesta = new AdhdStavka(pitanja.get(5), adhdUpitnik.getOdgovor6());
        AdhdStavka sedma = new AdhdStavka(pitanja.get(6), adhdUpitnik.getOdgovor7());
        AdhdStavka osma = new AdhdStavka(pitanja.get(7), adhdUpitnik.getOdgovor8());
        AdhdStavka deveta = new AdhdStavka(pitanja.get(8), adhdUpitnik.getOdgovor9());
        AdhdStavka deseta = new AdhdStavka(pitanja.get(9), adhdUpitnik.getOdgovor10());

        AdhdUpitnik upitnik = new AdhdUpitnik(prva, druga,treca,cetvrta,peta,sesta,sedma,osma,deveta,deseta);
        trenutniPregled.setAdhdUpitnik(upitnik);
        pregledServis.sacuvaj(trenutniPregled);
        adhdUpitnikRepozitorijum.save(upitnik);
    }
}
