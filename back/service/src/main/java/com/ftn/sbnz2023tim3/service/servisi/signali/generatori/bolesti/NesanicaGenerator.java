package com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;

import static com.ftn.sbnz2023tim3.service.servisi.signali.RandomUtils.generisiRandomBrojIzmedju;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.AlfaGenerator.generisiNormalanAlfaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.BetaGenerator.generisiNormalanBetaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.DeltaGenerator.generisiSnizenDeltaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.GamaGenerator.generisiNormalanGamaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.TetaGenerator.generisiSnizenTetaSignal;

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
                .alfaSignal(generisiNormalanAlfaSignal())
                .betaSignal(generisiNormalanBetaSignal())
                .gamaSignal(generisiNormalanGamaSignal())
                .deltaSignal(generisiSnizenDeltaSignal())
                .tetaSignal(generisiSnizenTetaSignal())
                .build();
    }
    private static GenerisanSignal generisiNesanicaTetaIDeltaOdsutno() {
        return GenerisanSignal.builder()
                .alfaSignal(generisiNormalanAlfaSignal())
                .betaSignal(generisiNormalanBetaSignal())
                .gamaSignal(generisiNormalanGamaSignal())
                .deltaSignal(null)
                .tetaSignal(null)
                .build();
    }
    private static GenerisanSignal generisiNesanicaTetaSmanjenoIDeltaOdsutno() {
        return GenerisanSignal.builder()
                .alfaSignal(generisiNormalanAlfaSignal())
                .betaSignal(generisiNormalanBetaSignal())
                .gamaSignal(generisiNormalanGamaSignal())
                .deltaSignal(null)
                .tetaSignal(generisiSnizenTetaSignal())
                .build();
    }
    private static GenerisanSignal generisiNesanicaTetaOdsutnoIDeltaSmanjeno() {
        return GenerisanSignal.builder()
                .alfaSignal(generisiNormalanAlfaSignal())
                .betaSignal(generisiNormalanBetaSignal())
                .gamaSignal(generisiNormalanGamaSignal())
                .deltaSignal(generisiSnizenDeltaSignal())
                .tetaSignal(null)
                .build();
    }
}
