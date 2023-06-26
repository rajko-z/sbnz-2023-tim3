package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.dto.InfoZaGenerisanSignal;
import com.ftn.sbnz2023tim3.model.modeli.dto.PronadjenaBolest;
import com.ftn.sbnz2023tim3.model.modeli.dto.RezultatSignala;
import com.ftn.sbnz2023tim3.model.modeli.dto.pregled.PregledDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.pregled.RezultatPregledaDTO;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjeEEGPregleda;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.Uzrast;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Doktor;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Pacijent;
import com.ftn.sbnz2023tim3.service.izuzeci.BadRequestException;
import com.ftn.sbnz2023tim3.service.izuzeci.NotFoundException;
import com.ftn.sbnz2023tim3.service.konfiguracija.DRoolsKonfiguracija;
import com.ftn.sbnz2023tim3.service.konverteri.KorisnikDTOKonverter;
import com.ftn.sbnz2023tim3.service.konverteri.LekoviDTOKonverter;
import com.ftn.sbnz2023tim3.service.konverteri.UpitniciDTOKonverter;
import com.ftn.sbnz2023tim3.service.repozitorijumi.PregledRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.DoktorServis;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.PacijentServis;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.kie.api.runtime.KieSession;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PregledServis {

    private final PregledRepozitorijum pregledRepozitorijum;

    private final PacijentServis pacijentServis;

    private final DoktorServis doktorServis;

    private final LekoviServis lekoviServis;

    private final DRoolsKonfiguracija dRoolsKonfiguracija;

    private final DeviceIntegracijaServis deviceIntegracijaServis;

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
        pregled.setStanjeEEGPregleda(StanjeEEGPregleda.NIJE_ZAPOCET);
        pregled.setZavrsen(false);
        pregled.setPacijent(pacijent);
        pregled.setDoktor(doktor);

        pacijent.setTrenutniPregled(pregled);
        doktor.setTrenutniPregled(pregled);

        pregledRepozitorijum.save(pregled);
    }

    public void sacuvaj(Pregled pregled) {
        this.pregledRepozitorijum.save(pregled);
    }

    public void zapocniEEG() {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledom();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException("Doktor nema trenutni pregled");
        }
        Pregled pregled = doktor.getTrenutniPregled();
        if (!StanjeEEGPregleda.NIJE_ZAPOCET.equals(pregled.getStanjeEEGPregleda())) {
            throw new BadRequestException("Za ovaj pregled je vec pokrenut eeg");
        }
        pregled.setStanjeEEGPregleda(StanjeEEGPregleda.U_TOKU);
        pregled.setEegVremePocetka(LocalDateTime.now());
        sacuvaj(pregled);

        KieSession ksessionStavka = dRoolsKonfiguracija.getOrCreateKieSession("signaliStavkaKS");
        ksessionStavka.insert(pregled);
        pokreniEEGAparat(pregled, pregled.getPacijent());
    }

    public Pregled zavrsiEEG() {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledom();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException("Doktor nema trenutni pregled");
        }

        Pregled pregled = doktor.getTrenutniPregled();
        pregled.setStanjeEEGPregleda(StanjeEEGPregleda.ZAVRSEN);
        pregled.setEegVremeZavrsetka(LocalDateTime.now());

        KieSession ksession = dRoolsKonfiguracija.getOrCreateKieSession("signaliStavkaKS");
        ksession.insert(pregled);
        insertPocenteRezultateSignala(ksession, pregled);
        ksession.fireAllRules();
        dRoolsKonfiguracija.clearKieSession(ksession);

        sacuvaj(pregled);

        deviceIntegracijaServis.sendToDeviceApp(null, "/signali/kraj", HttpMethod.PUT);
        return pregled;
    }

    private void pokreniEEGAparat(Pregled pregled, Pacijent pacijent) {
        boolean uzmiUObzirINesanicu = !pacijent.getUzrast().equals(Uzrast.DETE);
        if (pregled.getAdhdUpitnik() == null && pregled.getAlchajmerUpitnik() == null && pregled.getNesanicaUpitnik() == null && pregled.getEpilepsijaUpitnik() == null) {
            deviceIntegracijaServis.sendToDeviceApp(
                    new InfoZaGenerisanSignal(uzmiUObzirINesanicu, false, new ArrayList<>(), pregled.getId()),
                    "/signali/pocetak", HttpMethod.POST);
        } else {
            deviceIntegracijaServis.sendToDeviceApp(
                    new InfoZaGenerisanSignal(uzmiUObzirINesanicu, true, getProcentiUpitnikaIzPregleda(pregled, uzmiUObzirINesanicu), pregled.getId()),
                    "/signali/pocetak", HttpMethod.POST);
        }
    }

    private List<Pair<TipBolesti, Double>> getProcentiUpitnikaIzPregleda(Pregled pregled, boolean generisiNesanicu) {
        List<Pair<TipBolesti, Double>> procenti = new ArrayList<>();
        procenti.add(new ImmutablePair<>(TipBolesti.ADHD, pregled.getAdhdProcenat()));
        procenti.add(new ImmutablePair<>(TipBolesti.ALCHAJMER, pregled.getAlchajmerProcenat()));
        procenti.add(new ImmutablePair<>(TipBolesti.EPILEPSIJA, pregled.getEpilepsijaProcenat()));
        if (generisiNesanicu) {
            procenti.add(new ImmutablePair<>(TipBolesti.NESANICA, pregled.getNesanicaProcenat()));
        }
        return procenti;
    }

    private void insertPocenteRezultateSignala(KieSession kieSession, Pregled pregled) {
        RezultatSignala rezultatSignalaAlfa = new RezultatSignala(new Date(), pregled.getId(), TipSignala.ALFA, -1, -1, -1, -1);
        RezultatSignala rezultatSignalaBeta = new RezultatSignala(new Date(), pregled.getId(), TipSignala.BETA, -1, -1, -1, -1);
        RezultatSignala rezultatSignalaGama = new RezultatSignala(new Date(), pregled.getId(), TipSignala.GAMA, -1, -1, -1, -1);
        RezultatSignala rezultatSignalaDelta = new RezultatSignala(new Date(), pregled.getId(), TipSignala.DELTA, -1, -1, -1, -1);
        RezultatSignala rezultatSignalaTeta = new RezultatSignala(new Date(), pregled.getId(), TipSignala.TETA, -1, -1, -1, -1);
        kieSession.insert(rezultatSignalaAlfa);
        kieSession.insert(rezultatSignalaBeta);
        kieSession.insert(rezultatSignalaGama);
        kieSession.insert(rezultatSignalaDelta);
        kieSession.insert(rezultatSignalaTeta);
    }

    public Pregled getTrenutniPregled() {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledom();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException("Doktor nema trenutni pregled");
        }

        return doktor.getTrenutniPregled();
    }

    public PregledDTO getPregledDTOById(Long id) {
        Pregled pregled = pregledRepozitorijum.findByIdSaSvimPoljimaSemLekova(id);
        return konvertujPregledToPregledDTO(pregled);
    }

    public Pacijent getPacijentPregleda(Long pregledId) {
        return this.pregledRepozitorijum.getPregledSaPacijentom(pregledId).getPacijent();
    }

    public List<PregledDTO> getPreglediByDoktor() {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktor();
        ArrayList<Pregled> pregledi = pregledRepozitorijum.findAllByDoktorEmail(doktor.getEmail());
        ArrayList<PregledDTO> pregledDTOS = new ArrayList<>();
        for (Pregled pregled : pregledi) {
            pregledDTOS.add(konvertujPregledToPregledDTO(pregled));
        }
        return pregledDTOS;
    }

    public List<PregledDTO> getPreglediByPacijent() {
        Pacijent pacijent = pacijentServis.getTrenutnoUlogovaniPacijent();
        ArrayList<Pregled> pregledi = pregledRepozitorijum.findAllByPacijentEmail(pacijent.getEmail());
        ArrayList<PregledDTO> pregledDTOS = new ArrayList<>();
        for (Pregled pregled : pregledi) {
            pregledDTOS.add(konvertujPregledToPregledDTO(pregled));
        }
        return pregledDTOS;
    }

    private PregledDTO konvertujPregledToPregledDTO(Pregled pregled) {
        return PregledDTO.builder()
                .id(pregled.getId())
                .pacijent(KorisnikDTOKonverter.konvertuj(pregled.getPacijent()))
                .doktor(KorisnikDTOKonverter.konvertuj(pregled.getDoktor()))
                .adhdUpitnik(UpitniciDTOKonverter.konvertujAdhdUpitnik(pregled.getAdhdUpitnik()))
                .alchajmerUpitnik(UpitniciDTOKonverter.konvertujAlchajmerUpitnik(pregled.getAlchajmerUpitnik()))
                .nesanicaUpitnik(UpitniciDTOKonverter.konvertujNesanicaUpitnik(pregled.getNesanicaUpitnik()))
                .epilepsijaUpitnik(UpitniciDTOKonverter.konvertujEpilepsijaUpitnik(pregled.getEpilepsijaUpitnik()))
                .izdatiLekovi(lekoviServis.getIzdatiLekoviPoIdjuPregleda(pregled.getId()).stream().map(LekoviDTOKonverter::konvertujIzdatLek).collect(Collectors.toList()))
                .adhdProcenat(pregled.getAdhdProcenat())
                .epilepsijaProcenat(pregled.getEpilepsijaProcenat())
                .nesanicaProcenat(pregled.getNesanicaProcenat())
                .alchajmerProcenat(pregled.getAlchajmerProcenat())
                .beleske(pregled.getBeleske())
                .zakljucak(pregled.getZakljucak())
                .zavrsen(pregled.isZavrsen())
                .eegVremePocetka(pregled.getEegVremePocetka())
                .eegVremeZavrsetka(pregled.getEegVremeZavrsetka())
                .stanjeEEGPregleda(pregled.getStanjeEEGPregleda())
                .build();
    }

    public RezultatPregledaDTO vratiPregledSaSastojcima(Pregled pregled) {
        PronadjenaBolest pronadjenaBolest = pronadjiBolest(pregled);
        List<String> sastojci = new ArrayList<>();
        if (pronadjenaBolest.getTipBolesti() != null) {
            sastojci = lekoviServis.getSastojciZaTipBolesti(pronadjenaBolest.getTipBolesti());
        }

        return RezultatPregledaDTO.builder()
                .adhdProcenat(pregled.getAdhdProcenat())
                .alchajmerProcenat(pregled.getAlchajmerProcenat())
                .epilepsijaProcenat(pregled.getEpilepsijaProcenat())
                .nesanicaProcenat(pregled.getNesanicaProcenat())
                .procenatPronadjeneBolesti(pronadjenaBolest.getProcenat())
                .tipBolesti(pronadjenaBolest.getTipBolesti())
                .sastojci(sastojci)
                .build();
    }

    public PronadjenaBolest pronadjiBolest(Pregled pregled) {
        PronadjenaBolest pronadjenaBolest = new PronadjenaBolest();
        if (pregled.getAdhdProcenat() > 0.5 && pregled.getAdhdProcenat() > pronadjenaBolest.getProcenat()) {
            pronadjenaBolest.setProcenat(pregled.getAdhdProcenat());
            pronadjenaBolest.setTipBolesti(TipBolesti.ADHD);
        }
        if (pregled.getAlchajmerProcenat() > 0.5 && pregled.getAlchajmerProcenat() > pronadjenaBolest.getProcenat()) {
            pronadjenaBolest.setProcenat(pregled.getAlchajmerProcenat());
            pronadjenaBolest.setTipBolesti(TipBolesti.ALCHAJMER);
        }
        if (pregled.getNesanicaProcenat() > 0.5 && pregled.getNesanicaProcenat() > pronadjenaBolest.getProcenat()) {
            pronadjenaBolest.setProcenat(pregled.getNesanicaProcenat());
            pronadjenaBolest.setTipBolesti(TipBolesti.NESANICA);
        }
        if (pregled.getEpilepsijaProcenat() > 0.5 && pregled.getEpilepsijaProcenat() > pronadjenaBolest.getProcenat()) {
            pronadjenaBolest.setProcenat(pregled.getEpilepsijaProcenat());
            pronadjenaBolest.setTipBolesti(TipBolesti.EPILEPSIJA);
        }
        return pronadjenaBolest;
    }

    @Transactional
    public void zavrsiPregled() {
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledomIIstorijomPregleda();
        Pacijent pacijent = pacijentServis.getPacijentSaPregledomIIstorijomPregleda(doktor.getTrenutniPregled().getPacijent().getEmail());

        Pregled pregled = doktor.getTrenutniPregled();
        pregled.setZavrsen(true);

        doktor.getPregledi().add(pregled);
        pacijent.getPregledi().add(pregled);

        doktor.setTrenutniPregled(null);
        pacijent.setTrenutniPregled(null);

        pregledRepozitorijum.save(pregled);
        doktorServis.sacuvaj(doktor);
        pacijentServis.sacuvaj(pacijent);
    }
}
