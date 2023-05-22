package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.dto.pregled.PregledDTO;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjeEEGPregleda;
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
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PregledServis {

    private final PregledRepozitorijum pregledRepozitorijum;

    private final PacijentServis pacijentServis;

    private final DoktorServis doktorServis;

    private final LekoviServis lekoviServis;

    private final DRoolsKonfiguracija dRoolsKonfiguracija;

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
    }

    public void zavrsiEEG(){
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledom();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException("Doktor nema trenutni pregled");
        }

        Pregled pregled = doktor.getTrenutniPregled();
        pregled.setStanjeEEGPregleda(StanjeEEGPregleda.ZAVRSEN);
        pregled.setEegVremeZavrsetka(LocalDateTime.now());
        sacuvaj(pregled);

        KieSession ksession = dRoolsKonfiguracija.getOrCreateKieSession("signaliStavkaKS");
        ksession.insert(pregled);
        ksession.fireAllRules();

        doktor.setTrenutniPregled(null);
        doktorServis.sacuvaj(doktor);
    }

    public PregledDTO getPregledDTOById(Long id) {
        Pregled pregled = pregledRepozitorijum.findByIdSaSvimPoljimaSemLekova(id);
        return PregledDTO.builder()
                .id(id)
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

    public Pacijent getPacijentPregleda(Long pregledId) {
        return this.pregledRepozitorijum.getPregledSaPacijentom(pregledId).getPacijent();
    }
}
