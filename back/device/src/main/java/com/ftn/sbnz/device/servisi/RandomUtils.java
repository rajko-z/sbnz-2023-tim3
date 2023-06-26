package com.ftn.sbnz.device.servisi;

import com.ftn.sbnz.device.model.enumeracije.DeoMozga;

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
