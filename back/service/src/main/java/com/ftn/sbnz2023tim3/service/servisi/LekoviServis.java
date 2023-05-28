package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.dto.AlergijeDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.PronadjenaBolest;
import com.ftn.sbnz2023tim3.model.modeli.dto.lekovi.Lek;
import com.ftn.sbnz2023tim3.model.modeli.dto.lekovi.SignalZaKonacanIzborLekova;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjeEEGPregleda;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Doktor;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Pacijent;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.IzdatLek;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.OpisLeka;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.SastojakLeka;
import com.ftn.sbnz2023tim3.service.izuzeci.BadRequestException;
import com.ftn.sbnz2023tim3.service.konfiguracija.DRoolsKonfiguracija;
import com.ftn.sbnz2023tim3.service.repozitorijumi.IzdatiLekRepozitorijum;
import com.ftn.sbnz2023tim3.service.repozitorijumi.OpisLekaRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.DoktorServis;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LekoviServis {

    private final IzdatiLekRepozitorijum izdatiLekRepozitorijum;

    private final OpisLekaRepozitorijum opisLekaRepozitorijum;

    private final DoktorServis doktorServis;

    private final DRoolsKonfiguracija dRoolsKonfiguracija;

    private final PregledServis pregledServis;

    public LekoviServis(IzdatiLekRepozitorijum izdatiLekRepozitorijum, OpisLekaRepozitorijum opisLekaRepozitorijum, DoktorServis doktorServis, DRoolsKonfiguracija dRoolsKonfiguracija, @Lazy PregledServis pregledServis) {
        this.izdatiLekRepozitorijum = izdatiLekRepozitorijum;
        this.opisLekaRepozitorijum = opisLekaRepozitorijum;
        this.doktorServis = doktorServis;
        this.dRoolsKonfiguracija = dRoolsKonfiguracija;
        this.pregledServis = pregledServis;
    }

    public List<IzdatLek> getIzdatiLekoviPoIdjuPregleda(Long pregledId) {
        return izdatiLekRepozitorijum.pronadjiIzdateLekovePoIdjuPregleda(pregledId);
    }

    public List<String> getSastojciZaTipBolesti(TipBolesti tipBolesti) {
        List<String> sastojci = new ArrayList<>();
        List<OpisLeka> lekovi = opisLekaRepozitorijum.pronadjiOpiseLekovaSaSastojcimaPoTipuBolesti(tipBolesti);
        lekovi.forEach(lek -> sastojci.addAll(lek.getSastojci().stream().map(SastojakLeka::getNaziv).collect(Collectors.toList())));
        return sastojci;
    }

    public List<Lek> predloziLekovePacijentu(AlergijeDTO alergije) {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledom();
        Pregled pregled = doktor.getTrenutniPregled();
        Pacijent pacijent = doktor.getTrenutniPregled().getPacijent();

        validiraj(pregled);

        pacijent.setAlergije(alergije.getAlergije());

        List<Lek> lekovi = kreirajLekoveZaKSession(pregled);
        KieSession ksession = dRoolsKonfiguracija.getOrCreateKieSession("predlogLekovaKS");
        ksession.insert(pregled);
        ksession.insert(pacijent);
        lekovi.forEach(ksession::insert);
        ksession.fireAllRules();
        ksession.insert(new SignalZaKonacanIzborLekova());
        ksession.fireAllRules();
        dRoolsKonfiguracija.clearKieSession(ksession);

        setujIzdateLekoveZaPregled(pregled);

        return pregled.getPredlozeniLekovi();
    }

    private void setujIzdateLekoveZaPregled(Pregled pregled) {
        List<IzdatLek> izdatiLekovi = new ArrayList<>();
        for (Lek lek : pregled.getPredlozeniLekovi()) {
            IzdatLek izdatLek = new IzdatLek();
            izdatLek.setOpisLeka(opisLekaRepozitorijum.pronadjiPoNazivu(lek.getNaziv()));
            izdatLek.setPregled(pregled);
            izdatLek.setOpisDoze(lek.getOpisDoze());
            izdatiLekovi.add(izdatLek);
        }
        pregled.setIzdatiLekovi(izdatiLekovi);
        pregledServis.sacuvaj(pregled);
    }

    private List<Lek> kreirajLekoveZaKSession(Pregled pregled) {
        PronadjenaBolest pronadjenaBolest = pregledServis.pronadjiBolest(pregled);
        List<OpisLeka> opisiLekova = opisLekaRepozitorijum.pronadjiOpiseLekovaSaSastojcimaPoTipuBolesti(pronadjenaBolest.getTipBolesti());

        List<Lek> lekovi = new ArrayList<>();
        for (OpisLeka opisLeka : opisiLekova) {
            Lek lek = new Lek();
            lek.setPregled(pregled);
            lek.setSastojci(opisLeka.getSastojci().stream().map(SastojakLeka::getNaziv).collect(Collectors.toList()));
            lek.setDozvoljeniUzrasti(opisLekaRepozitorijum.pronadjiOpisLekaSaUzrastima(opisLeka.getId()).getDozvoljeniUzrasti());
            lek.setNaziv(opisLeka.getNaziv());
            lek.setTipBolesti(opisLeka.getTipBolesti());
            lek.setZaBlaguBolest(opisLeka.isZaBlaguBolest());
            lek.setZaSrednjuBolest(opisLeka.isZaSrednjuBolest());
            lek.setZaTeskuBolest(opisLeka.isZaTeskuBolest());
            lekovi.add(lek);
        }
        return lekovi;
    }

    private void validiraj(Pregled pregled) {
        if (pregled == null) {
            throw new BadRequestException("Doktor nema trenutni pregled");
        }
        if (!StanjeEEGPregleda.ZAVRSEN.equals(pregled.getStanjeEEGPregleda())) {
            throw new BadRequestException("Predlozi lekova se nude tek nakon zavrsetka EEG analize");
        }
        if (pregled.isZavrsen()) {
            throw new BadRequestException("Pregled je zavrsen, nije moguce naknadno ponuditi lekove");
        }
        if (pregled.zdravRezultat()) {
            throw new BadRequestException("Nije moguce predloziti lek za pregled u kojem nisu pronadjene bolesti");
        }
    }
}
