package com.ftn.sbnz2023tim3.service.servisi.signali;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.DeoMozga;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti.AdhdGenerator;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti.AlchajmerGenerator;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti.EpilepsijaGenerator;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti.NesanicaGenerator;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.*;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();

    private RandomUtils() {}

    public static int generisiRandomBrojIzmedju(int a, int b) {
        int donja = a;
        int gornja = b + 1;
        return random.nextInt(gornja - donja) + donja;
    }

    public static DeoMozga izaberiDeoMozgaNasumicno(List<DeoMozga> delovi) {
        return delovi.get(random.nextInt(delovi.size()));
    }
}
