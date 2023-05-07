package com.ftn.sbnz2023tim3.service.konverteri;

import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.adhd.PopunjenAdhdUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.alchajmer.PopunjenAlchajmerUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.epilepsija.PopunjenEpilepsijaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.nesanica.PopunjenNesanicaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.adhd.AdhdUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.alchajmer.AlchajmerUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.epilepsija.EpilepsijaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.nesanica.NesanicaUpitnik;

public class UpitniciDTOKonverter {

    private UpitniciDTOKonverter() {}

    public static PopunjenAdhdUpitnik konvertujAdhdUpitnik(AdhdUpitnik adhdUpitnik) {
        if (adhdUpitnik == null) return null;
        return PopunjenAdhdUpitnik.builder()
                .odgovor1(adhdUpitnik.getPrva().getOdgovor())
                .odgovor2(adhdUpitnik.getDruga().getOdgovor())
                .odgovor3(adhdUpitnik.getTreca().getOdgovor())
                .odgovor4(adhdUpitnik.getCetvrta().getOdgovor())
                .odgovor5(adhdUpitnik.getPeta().getOdgovor())
                .odgovor6(adhdUpitnik.getSesta().getOdgovor())
                .odgovor7(adhdUpitnik.getSedma().getOdgovor())
                .odgovor8(adhdUpitnik.getOsma().getOdgovor())
                .odgovor9(adhdUpitnik.getDeveta().getOdgovor())
                .odgovor10(adhdUpitnik.getDeseta().getOdgovor())
                .build();
    }

    public static PopunjenAlchajmerUpitnik konvertujAlchajmerUpitnik(AlchajmerUpitnik alchajmerUpitnik) {
        if (alchajmerUpitnik == null) return null;
        return PopunjenAlchajmerUpitnik.builder()
                .odgovor1(alchajmerUpitnik.getPrva().getOdgovor())
                .odgovor2(alchajmerUpitnik.getDruga().getOdgovor())
                .odgovor3(alchajmerUpitnik.getTreca().getOdgovor())
                .odgovor4(alchajmerUpitnik.getCetvrta().getOdgovor())
                .odgovor5(alchajmerUpitnik.getPeta().getOdgovor())
                .odgovor6(alchajmerUpitnik.getSesta().getOdgovor())
                .odgovor7(alchajmerUpitnik.getSedma().getOdgovor())
                .odgovor8(alchajmerUpitnik.getOsma().getOdgovor())
                .odgovor9(alchajmerUpitnik.getDeveta().getOdgovor())
                .odgovor10(alchajmerUpitnik.getDeseta().getOdgovor())
                .build();
    }

    public static PopunjenEpilepsijaUpitnik konvertujEpilepsijaUpitnik(EpilepsijaUpitnik epilepsijaUpitnik) {
        if (epilepsijaUpitnik == null) return null;
        return PopunjenEpilepsijaUpitnik.builder()
                .odgovor1(epilepsijaUpitnik.getPrva().getOdgovor())
                .odgovor2(epilepsijaUpitnik.getDruga().getOdgovor())
                .odgovor3(epilepsijaUpitnik.getTreca().getOdgovor())
                .odgovor4(epilepsijaUpitnik.getCetvrta().getOdgovor())
                .odgovor5(epilepsijaUpitnik.getPeta().getOdgovor())
                .odgovor6(epilepsijaUpitnik.getSesta().getOdgovor())
                .odgovor7(epilepsijaUpitnik.getSedma().getOdgovor())
                .odgovor8(epilepsijaUpitnik.getOsma().getOdgovor())
                .odgovor9(epilepsijaUpitnik.getDeveta().getOdgovor())
                .odgovor10(epilepsijaUpitnik.getDeseta().getOdgovor())
                .build();
    }

    public static PopunjenNesanicaUpitnik konvertujNesanicaUpitnik(NesanicaUpitnik nesanicaUpitnik) {
        if (nesanicaUpitnik == null) return null;
        return PopunjenNesanicaUpitnik.builder()
                .odgovor1(nesanicaUpitnik.getPrva().getOdgovor())
                .odgovor2(nesanicaUpitnik.getDruga().getOdgovor())
                .odgovor3(nesanicaUpitnik.getTreca().getOdgovor())
                .odgovor4(nesanicaUpitnik.getCetvrta().getOdgovor())
                .odgovor5(nesanicaUpitnik.getPeta().getOdgovor())
                .odgovor6(nesanicaUpitnik.getSesta().getOdgovor())
                .odgovor7(nesanicaUpitnik.getSedma().getOdgovor())
                .odgovor8(nesanicaUpitnik.getOsma().getOdgovor())
                .odgovor9(nesanicaUpitnik.getDeveta().getOdgovor())
                .odgovor10(nesanicaUpitnik.getDeseta().getOdgovor())
                .build();
    }
}
