package com.ftn.sbnz2023tim3.service.servisi.upitnici;

import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.epilepsija.PopunjenEpilepsijaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.epilepsija.*;
import com.ftn.sbnz2023tim3.service.konfiguracija.DRoolsKonfiguracija;
import com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.epilepsija.EpilepsijaPitanjeRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EpilepsijaUpitnikServis {

    private final EpilepsijaPitanjeRepozitorijum epilepsijaPitanjeRepozitorijum;

    private final PregledServis pregledServis;

    private final DRoolsKonfiguracija dRoolsKonfiguracija;

    @Transactional
    public void dodaj(PopunjenEpilepsijaUpitnik epilepsijaUpitnik, Pregled trenutniPregled) {
        List<EpilepsijaPitanje> pitanja = epilepsijaPitanjeRepozitorijum.findAll();

        KieSession ksession = dRoolsKonfiguracija.getOrCreateKieSession("upitniciKS");
        ksession.insert(trenutniPregled);

        EpilepsijaDaNeStavka prva = new EpilepsijaDaNeStavka(epilepsijaUpitnik.getOdgovor1(), pitanja.get(0));
        prva.setPregled(trenutniPregled);
        ksession.insert(prva);

        EpilepsijaUcestalostStavka druga = new EpilepsijaUcestalostStavka(epilepsijaUpitnik.getOdgovor2(), pitanja.get(1));
        druga.setPregled(trenutniPregled);
        ksession.insert(druga);

        EpilepsijaVremenskaStavka treca = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor3(), pitanja.get(2));
        treca.setPregled(trenutniPregled);
        ksession.insert(treca);

        EpilepsijaVremenskaStavka cetvrta = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor4(), pitanja.get(3));
        cetvrta.setPregled(trenutniPregled);
        ksession.insert(cetvrta);

        EpilepsijaVremenskaStavka peta = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor5(), pitanja.get(4));
        peta.setPregled(trenutniPregled);
        ksession.insert(peta);

        EpilepsijaVremenskaStavka sesta = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor6(), pitanja.get(5));
        sesta.setPregled(trenutniPregled);
        ksession.insert(sesta);

        EpilepsijaVremenskaStavka sedma = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor7(), pitanja.get(6));
        sedma.setPregled(trenutniPregled);
        ksession.insert(sedma);

        EpilepsijaDaNeStavka osma = new EpilepsijaDaNeStavka(epilepsijaUpitnik.getOdgovor8(), pitanja.get(7));
        osma.setPregled(trenutniPregled);
        ksession.insert(osma);

        EpilepsijaDaNeStavka deveta = new EpilepsijaDaNeStavka(epilepsijaUpitnik.getOdgovor9(), pitanja.get(8));
        deveta.setPregled(trenutniPregled);
        ksession.insert(deveta);

        EpilepsijaVremenskaStavka deseta = new EpilepsijaVremenskaStavka(epilepsijaUpitnik.getOdgovor10(), pitanja.get(9));
        deseta.setPregled(trenutniPregled);
        ksession.insert(deseta);

        ksession.fireAllRules();
        dRoolsKonfiguracija.clearKieSession(ksession);

        EpilepsijaUpitnik upitnik = new EpilepsijaUpitnik(prva, druga, treca, cetvrta, peta, sesta, sedma, osma, deveta, deseta);
        trenutniPregled.setEpilepsijaUpitnik(upitnik);
        pregledServis.sacuvaj(trenutniPregled);
    }


}
