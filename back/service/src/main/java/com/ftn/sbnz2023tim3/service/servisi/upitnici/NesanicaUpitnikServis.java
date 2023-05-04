package com.ftn.sbnz2023tim3.service.servisi.upitnici;

import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.PopunjenNesanicaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.nesanica.*;
import com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.nesanica.NesanicaPitanjeRepozitorijum;
import com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.nesanica.NesanicaUpitnikRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class NesanicaUpitnikServis {

    private NesanicaUpitnikRepozitorijum nesanicaUpitnikRepozitorijum;
    
    private NesanicaPitanjeRepozitorijum nesanicaPitanjeRepozitorijum;

    private final PregledServis pregledServis;

    @Transactional
    public void dodaj(PopunjenNesanicaUpitnik nesanicaUpitnik, Pregled trenutniPregled) {
        List<NesanicaPitanje> pitanja = nesanicaPitanjeRepozitorijum.findAll();

        NesanicaVremenskaStavka prva = new NesanicaVremenskaStavka(nesanicaUpitnik.getOdgovor1(), pitanja.get(0));
        NesanicaTrajanjeStavka druga = new NesanicaTrajanjeStavka(nesanicaUpitnik.getOdgovor2(), pitanja.get(1));
        NesanicaDaNeStavka treca = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor3(), pitanja.get(2));
        NesanicaDaNeStavka cetvrta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor4(), pitanja.get(3));
        NesanicaDaNeStavka peta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor5(),pitanja.get(4));
        NesanicaDaNeStavka sesta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor6(),pitanja.get(5));
        NesanicaDaNeStavka sedma = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor7(),pitanja.get(6));
        NesanicaVremenskaStavka osma = new NesanicaVremenskaStavka(nesanicaUpitnik.getOdgovor8(),pitanja.get(7));
        NesanicaDaNeStavka deveta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor9(),pitanja.get(8));
        NesanicaDaNeStavka deseta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor10(),pitanja.get(9));

        NesanicaUpitnik upitnik = new NesanicaUpitnik(prva, druga,treca,cetvrta,peta,sesta,sedma,osma,deveta,deseta);
        trenutniPregled.setNesanicaUpitnik(upitnik);
        pregledServis.sacuvaj(trenutniPregled);
        nesanicaUpitnikRepozitorijum.save(upitnik);
    }
}
