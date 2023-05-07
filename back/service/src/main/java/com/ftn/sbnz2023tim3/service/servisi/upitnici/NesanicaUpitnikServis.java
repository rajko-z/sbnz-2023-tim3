package com.ftn.sbnz2023tim3.service.servisi.upitnici;

import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.nesanica.PopunjenNesanicaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.nesanica.*;
import com.ftn.sbnz2023tim3.service.konfiguracija.DRoolsKonfiguracija;
import com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.nesanica.NesanicaPitanjeRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class NesanicaUpitnikServis {

    private NesanicaPitanjeRepozitorijum nesanicaPitanjeRepozitorijum;

    private final PregledServis pregledServis;

    private final DRoolsKonfiguracija dRoolsKonfiguracija;

    @Transactional
    public void dodaj(PopunjenNesanicaUpitnik nesanicaUpitnik, Pregled trenutniPregled) {
        List<NesanicaPitanje> pitanja = nesanicaPitanjeRepozitorijum.findAll();

        KieSession ksession = dRoolsKonfiguracija.getOrCreateKieSession("upitniciKS");
        ksession.insert(trenutniPregled);

        NesanicaVremenskaStavka prva = new NesanicaVremenskaStavka(nesanicaUpitnik.getOdgovor1(), pitanja.get(0));
        prva.setPregled(trenutniPregled);
        ksession.insert(prva);

        NesanicaTrajanjeStavka druga = new NesanicaTrajanjeStavka(nesanicaUpitnik.getOdgovor2(), pitanja.get(1));
        druga.setPregled(trenutniPregled);
        ksession.insert(druga);

        NesanicaDaNeStavka treca = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor3(), pitanja.get(2));
        treca.setPregled(trenutniPregled);
        ksession.insert(treca);

        NesanicaDaNeStavka cetvrta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor4(), pitanja.get(3));
        cetvrta.setPregled(trenutniPregled);
        ksession.insert(cetvrta);

        NesanicaDaNeStavka peta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor5(),pitanja.get(4));
        peta.setPregled(trenutniPregled);
        ksession.insert(peta);

        NesanicaDaNeStavka sesta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor6(),pitanja.get(5));
        sesta.setPregled(trenutniPregled);
        ksession.insert(sesta);

        NesanicaDaNeStavka sedma = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor7(),pitanja.get(6));
        sedma.setPregled(trenutniPregled);
        ksession.insert(sedma);

        NesanicaVremenskaStavka osma = new NesanicaVremenskaStavka(nesanicaUpitnik.getOdgovor8(),pitanja.get(7));
        osma.setPregled(trenutniPregled);
        ksession.insert(osma);

        NesanicaDaNeStavka deveta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor9(),pitanja.get(8));
        deveta.setPregled(trenutniPregled);
        ksession.insert(deveta);

        NesanicaDaNeStavka deseta = new NesanicaDaNeStavka(nesanicaUpitnik.getOdgovor10(),pitanja.get(9));
        deseta.setPregled(trenutniPregled);
        ksession.insert(deseta);
        ksession.fireAllRules();
        dRoolsKonfiguracija.clearKieSession(ksession);

        NesanicaUpitnik upitnik = new NesanicaUpitnik(prva, druga,treca,cetvrta,peta,sesta,sedma,osma,deveta,deseta);
        trenutniPregled.setNesanicaUpitnik(upitnik);
        pregledServis.sacuvaj(trenutniPregled);
    }
}
