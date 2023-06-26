package com.ftn.sbnz.device.servisi.generatori.signala;

import com.ftn.sbnz.device.model.enumeracije.DeoMozga;
import com.ftn.sbnz.device.model.Signal;
import com.ftn.sbnz.device.model.enumeracije.StanjePacijenta;

import java.util.Date;
import java.util.List;

import static com.ftn.sbnz.device.servisi.RandomUtils.generisiRandomBrojIzmedju;
import static com.ftn.sbnz.device.servisi.RandomUtils.izaberiDeoMozgaNasumicno;

public class DeltaGenerator {

    private DeltaGenerator() {}

    public static Signal generisiDeltaSignal(int frekDonja, int frekGornja, int ampDonja, int ampGornja) {
        return Signal.builder()
                .deoMozga(izaberiDeoMozgaNasumicno(List.of(DeoMozga.TEMENI, DeoMozga.FRONTALNI, DeoMozga.POTILJACNI, DeoMozga.TEMPORALNI)))
                .timestamp(new Date())
                .stanjePacijenta(StanjePacijenta.SAN)
                .frekvencija(generisiRandomBrojIzmedju(frekDonja, frekGornja))
                .amplituda(generisiRandomBrojIzmedju(ampDonja,ampGornja))
                .build();
    }
    public static Signal generisiNormalanDeltaSignal() {
        return generisiDeltaSignal(0,4,60,100);
    }
    public static Signal generisiPovisenDeltaSignal() {
        return generisiDeltaSignal(5,6,101,110);
    }
    public static Signal generisiSnizenDeltaSignal() {
        return generisiDeltaSignal(0,0,50,59);
    }

}
