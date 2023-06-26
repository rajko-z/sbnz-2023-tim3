package com.ftn.sbnz.device.servisi.generatori.signala;

import com.ftn.sbnz.device.model.enumeracije.DeoMozga;
import com.ftn.sbnz.device.model.Signal;
import com.ftn.sbnz.device.model.enumeracije.StanjePacijenta;

import java.util.Date;
import java.util.List;

import static com.ftn.sbnz.device.servisi.RandomUtils.generisiRandomBrojIzmedju;
import static com.ftn.sbnz.device.servisi.RandomUtils.izaberiDeoMozgaNasumicno;

public class BetaGenerator {

    private BetaGenerator() {}

    public static Signal generisiBetaSignal(int frekDonja, int frekGornja, int ampDonja, int ampGornja) {
        return Signal.builder()
                .deoMozga(izaberiDeoMozgaNasumicno(List.of(DeoMozga.TEMENI, DeoMozga.FRONTALNI)))
                .timestamp(new Date())
                .stanjePacijenta(StanjePacijenta.POJACANA_AKTIVNOST_MOZGA)
                .frekvencija(generisiRandomBrojIzmedju(frekDonja, frekGornja))
                .amplituda(generisiRandomBrojIzmedju(ampDonja,ampGornja))
                .build();
    }
    public static Signal generisiNormalanBetaSignal() {
        return generisiBetaSignal(12,30,15,25);
    }
    public static Signal generisiPovisenBetaSignal() {
        return generisiBetaSignal(31,35,26,30);
    }
    public static Signal generisiSnizenBetaSignal() {
        return generisiBetaSignal(10,11,10,14);
    }

}
