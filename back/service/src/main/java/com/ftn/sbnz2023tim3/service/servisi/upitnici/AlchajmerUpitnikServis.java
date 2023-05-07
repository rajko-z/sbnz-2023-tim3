package com.ftn.sbnz2023tim3.service.servisi.upitnici;

import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.alchajmer.PopunjenAlchajmerUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.alchajmer.AlchajmerPitanje;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.alchajmer.AlchajmerStavka;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.alchajmer.AlchajmerUpitnik;
import com.ftn.sbnz2023tim3.service.konfiguracija.DRoolsKonfiguracija;
import com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.alchajmer.AlchajmerPitanjeRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AlchajmerUpitnikServis {

    private final AlchajmerPitanjeRepozitorijum alchajmerPitanjeRepozitorijum;

    private final PregledServis pregledServis;

    private final DRoolsKonfiguracija dRoolsKonfiguracija;

    @Transactional
    public void dodaj(PopunjenAlchajmerUpitnik alchajmerUpitnik, Pregled trenutniPregled) {
        List<AlchajmerPitanje> pitanja = alchajmerPitanjeRepozitorijum.findAll();
        AlchajmerStavka prva = new AlchajmerStavka(pitanja.get(0), alchajmerUpitnik.getOdgovor1());
        AlchajmerStavka druga = new AlchajmerStavka(pitanja.get(1), alchajmerUpitnik.getOdgovor2());
        AlchajmerStavka treca = new AlchajmerStavka(pitanja.get(2), alchajmerUpitnik.getOdgovor3());
        AlchajmerStavka cetvrta = new AlchajmerStavka(pitanja.get(3), alchajmerUpitnik.getOdgovor4());
        AlchajmerStavka peta = new AlchajmerStavka(pitanja.get(4), alchajmerUpitnik.getOdgovor5());
        AlchajmerStavka sesta = new AlchajmerStavka(pitanja.get(5), alchajmerUpitnik.getOdgovor6());
        AlchajmerStavka sedma = new AlchajmerStavka(pitanja.get(6), alchajmerUpitnik.getOdgovor7());
        AlchajmerStavka osma = new AlchajmerStavka(pitanja.get(7), alchajmerUpitnik.getOdgovor8());
        AlchajmerStavka deveta = new AlchajmerStavka(pitanja.get(8), alchajmerUpitnik.getOdgovor9());
        AlchajmerStavka deseta = new AlchajmerStavka(pitanja.get(9), alchajmerUpitnik.getOdgovor10());

        AlchajmerUpitnik upitnik = new AlchajmerUpitnik(prva, druga,treca,cetvrta,peta,sesta,sedma,osma,deveta,deseta);
        upitnik.setPregled(trenutniPregled);

        KieSession ksession = dRoolsKonfiguracija.getOrCreateKieSession("upitniciKS");
        ksession.insert(trenutniPregled);
        ksession.insert(upitnik);
        ksession.fireAllRules();
        dRoolsKonfiguracija.clearKieSession(ksession);

        trenutniPregled.setAlchajmerUpitnik(upitnik);
        pregledServis.sacuvaj(trenutniPregled);
    }

}
