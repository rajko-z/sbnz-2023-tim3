package com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala;

import com.ftn.sbnz2023tim3.model.modeli.dto.Signal;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.DeoMozga;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjePacijenta;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.ftn.sbnz2023tim3.service.servisi.signali.RandomUtils.generisiRandomBrojIzmedju;
import static com.ftn.sbnz2023tim3.service.servisi.signali.RandomUtils.izaberiDeoMozgaNasumicno;

public class GamaGenerator {

    private GamaGenerator() {}

    public static Signal generisiGamaSignal(int frekDonja, int frekGornja, int ampDonja, int ampGornja) {
        return Signal.builder()
                .deoMozga(izaberiDeoMozgaNasumicno(List.of(DeoMozga.TEMENI, DeoMozga.FRONTALNI, DeoMozga.POTILJACNI, DeoMozga.TEMPORALNI)))
                .timestamp(new Date())
                .stanjePacijenta(StanjePacijenta.VISOKO_PROCESIRANJE_PODATAKA)
                .frekvencija(generisiRandomBrojIzmedju(frekDonja, frekGornja))
                .amplituda(generisiRandomBrojIzmedju(ampDonja,ampGornja))
                .build();
    }
    public static Signal generisiNormalanGamaSignal() {
        return generisiGamaSignal(30,100,10,50);
    }
    public static Signal generisiPovisenGamaSignal() {
        return generisiGamaSignal(101,120,51,60);
    }
    public static Signal generisiSnizenGamaSignal() {
        return generisiGamaSignal(20,29,0,9);
    }
}
