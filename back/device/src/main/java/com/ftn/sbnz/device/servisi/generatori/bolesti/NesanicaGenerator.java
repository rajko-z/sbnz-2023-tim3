package com.ftn.sbnz.device.servisi.generatori.bolesti;

import com.ftn.sbnz.device.model.GenerisanSignal;

import java.util.Arrays;

import static com.ftn.sbnz.device.servisi.RandomUtils.generisiRandomBrojIzmedju;
import static com.ftn.sbnz.device.servisi.generatori.signala.AlfaGenerator.generisiNormalanAlfaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.BetaGenerator.generisiNormalanBetaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.DeltaGenerator.generisiSnizenDeltaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.GamaGenerator.generisiNormalanGamaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.TetaGenerator.generisiSnizenTetaSignal;

public class NesanicaGenerator {

    private NesanicaGenerator() {}

    public static GenerisanSignal generisiNesanica() {
        int randomBroj = generisiRandomBrojIzmedju(1,4);
        if (randomBroj == 1)
            return generisiNesanicaTetaIDeltaSmanjeno();
        if (randomBroj == 2)
            return generisiNesanicaTetaIDeltaOdsutno();
        if (randomBroj == 3)
            return generisiNesanicaTetaSmanjenoIDeltaOdsutno();
        return generisiNesanicaTetaOdsutnoIDeltaSmanjeno();
    }

    private static GenerisanSignal generisiNesanicaTetaIDeltaSmanjeno() {
        return GenerisanSignal.builder()
                .signals(Arrays.asList(
                        generisiNormalanAlfaSignal(),
                        generisiNormalanBetaSignal(),
                        generisiNormalanGamaSignal(),
                        generisiSnizenDeltaSignal(),
                        generisiSnizenTetaSignal()
                ))
                .build();
    }
    private static GenerisanSignal generisiNesanicaTetaIDeltaOdsutno() {
        return GenerisanSignal.builder()
                .signals(Arrays.asList(
                        generisiNormalanAlfaSignal(),
                        generisiNormalanBetaSignal(),
                        generisiNormalanGamaSignal()
                ))
                .build();
    }
    private static GenerisanSignal generisiNesanicaTetaSmanjenoIDeltaOdsutno() {
        return GenerisanSignal.builder()
                .signals(Arrays.asList(
                        generisiNormalanAlfaSignal(),
                        generisiNormalanBetaSignal(),
                        generisiNormalanGamaSignal(),
                        generisiSnizenTetaSignal()
                ))
                .build();
    }
    private static GenerisanSignal generisiNesanicaTetaOdsutnoIDeltaSmanjeno() {
        return GenerisanSignal.builder()
                .signals(Arrays.asList(
                        generisiNormalanAlfaSignal(),
                        generisiNormalanBetaSignal(),
                        generisiNormalanGamaSignal(),
                        generisiSnizenDeltaSignal()
                ))
                .build();
    }
}
