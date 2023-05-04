package com.ftn.sbnz2023tim3.service.servisi.upitnici;

import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.PopunjenEpilepsijaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.epilepsija.*;
import com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.epilepsija.EpilepsijaPitanjeRepozitorijum;
import com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.epilepsija.EpilepsijaUpitnikRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EpilepsijaUpitnikServis {

    private final EpilepsijaUpitnikRepozitorijum epilepsijaUpitnikRepozitorijum;

    private final EpilepsijaPitanjeRepozitorijum epilepsijaPitanjeRepozitorijum;

    private final PregledServis pregledServis;

    @Transactional
    public void dodaj(PopunjenEpilepsijaUpitnik epilepsijaUpitnik, Pregled trenutniPregled) {
        List<EpilepsijaPitanje> pitanja = epilepsijaPitanjeRepozitorijum.findAll();

        EpilepsijaDaNeStavka prva = new EpilepsijaDaNeStavka(epilepsijaUpitnik.getOdgovor1(), pitanja.get(0));
        EpilepsijaUcestalostStavka druga = new EpilepsijaUcestalostStavka(epilepsijaUpitnik.getOdgovor2(), pitanja.get(1));
        EpilepsijaVremenskaStavka treca = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor3(), pitanja.get(2));
        EpilepsijaVremenskaStavka cetvrta = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor4(), pitanja.get(3));
        EpilepsijaVremenskaStavka peta = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor5(), pitanja.get(4));
        EpilepsijaVremenskaStavka sesta = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor6(), pitanja.get(5));
        EpilepsijaVremenskaStavka sedma = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor7(), pitanja.get(6));
        EpilepsijaDaNeStavka osma = new EpilepsijaDaNeStavka(epilepsijaUpitnik.getOdgovor8(), pitanja.get(7));
        EpilepsijaDaNeStavka deveta = new EpilepsijaDaNeStavka(epilepsijaUpitnik.getOdgovor9(), pitanja.get(8));
        EpilepsijaVremenskaStavka deseta = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor10(), pitanja.get(9));

        EpilepsijaUpitnik upitnik = new EpilepsijaUpitnik(prva, druga, treca, cetvrta, peta, sesta, sedma, osma, deveta, deseta);
        trenutniPregled.setEpilepsijaUpitnik(upitnik);
        pregledServis.sacuvaj(trenutniPregled);
        epilepsijaUpitnikRepozitorijum.save(upitnik);
    }
}
