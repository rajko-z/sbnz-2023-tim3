package com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala;

import com.ftn.sbnz2023tim3.model.modeli.dto.Signal;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.DeoMozga;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjePacijenta;

import java.util.Date;
import java.util.List;

import static com.ftn.sbnz2023tim3.service.servisi.signali.RandomUtils.generisiRandomBrojIzmedju;
import static com.ftn.sbnz2023tim3.service.servisi.signali.RandomUtils.izaberiDeoMozgaNasumicno;

public class TetaGenerator {

    private TetaGenerator() {}

    public static Signal generisiTetaSignal(int frekDonja, int frekGornja, int ampDonja, int ampGornja) {
        return Signal.builder()
                .deoMozga(izaberiDeoMozgaNasumicno(List.of(DeoMozga.TEMENI, DeoMozga.TEMPORALNI)))
                .timestamp(new Date())
                .stanjePacijenta(StanjePacijenta.NAPETOST)
                .frekvencija(generisiRandomBrojIzmedju(frekDonja, frekGornja))
                .amplituda(generisiRandomBrojIzmedju(ampDonja,ampGornja))
                .build();
    }
    public static Signal generisiNormalanTetaSignal() {
        return generisiTetaSignal(4,8,65,75);
    }
    public static Signal generisiPovisenTetaSignal() {
        return generisiTetaSignal(9,10,76,80);
    }
    public static Signal generisiSnizenTetaSignal() {
        return generisiTetaSignal(2,3,60,64);
    }
}
