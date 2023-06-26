package com.ftn.sbnz.device.servisi.generatori.signala;

import com.ftn.sbnz.device.model.enumeracije.DeoMozga;
import com.ftn.sbnz.device.model.Signal;
import com.ftn.sbnz.device.model.enumeracije.StanjePacijenta;

import java.util.Date;
import java.util.List;

import static com.ftn.sbnz.device.servisi.RandomUtils.generisiRandomBrojIzmedju;
import static com.ftn.sbnz.device.servisi.RandomUtils.izaberiDeoMozgaNasumicno;


public class AlfaGenerator {

    private AlfaGenerator() {}

    public static Signal generisiAlfaSignal(int frekDonja, int frekGornja, int ampDonja, int ampGornja) {
        return Signal.builder()
                .deoMozga(izaberiDeoMozgaNasumicno(List.of(DeoMozga.TEMENI, DeoMozga.POTILJACNI, DeoMozga.FRONTALNI)))
                .timestamp(new Date())
                .stanjePacijenta(StanjePacijenta.OPUSTENO_STANJE)
                .frekvencija(generisiRandomBrojIzmedju(frekDonja, frekGornja))
                .amplituda(generisiRandomBrojIzmedju(ampDonja,ampGornja))
                .build();
    }
    public static Signal generisiNormalanAlfaSignal() {
        return generisiAlfaSignal(8,12,45,55);
    }
    public static Signal generisiPovisenAlfaSignal() {
        return generisiAlfaSignal(13, 15, 56,60);
    }
    public static Signal generisiSnizenAlfaSignal() {
        return generisiAlfaSignal(5,7, 40, 44);
    }
}
