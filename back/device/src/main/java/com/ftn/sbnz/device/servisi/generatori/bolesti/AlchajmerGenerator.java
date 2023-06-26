package com.ftn.sbnz.device.servisi.generatori.bolesti;

import com.ftn.sbnz.device.model.GenerisanSignal;

import java.util.Arrays;

import static com.ftn.sbnz.device.servisi.RandomUtils.generisiRandomBrojIzmedju;
import static com.ftn.sbnz.device.servisi.generatori.signala.AlfaGenerator.generisiSnizenAlfaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.BetaGenerator.generisiNormalanBetaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.DeltaGenerator.generisiPovisenDeltaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.GamaGenerator.generisiNormalanGamaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.TetaGenerator.generisiPovisenTetaSignal;


public class AlchajmerGenerator {

    private AlchajmerGenerator() {
    }


    public static GenerisanSignal generisiAlchajmer() {
        int randomBroj = generisiRandomBrojIzmedju(1, 2);
        if (randomBroj == 1)
            return generisiAlfaSmanjenoTetaIDeltaPoviseno();
        return generisiAlfaOdsutnoTetaIDeltaPoviseno();
    }

    private static GenerisanSignal generisiAlfaSmanjenoTetaIDeltaPoviseno() {
        return GenerisanSignal.builder()
                .signals(Arrays.asList(
                        generisiSnizenAlfaSignal(),
                        generisiNormalanBetaSignal(),
                        generisiNormalanGamaSignal(),
                        generisiPovisenDeltaSignal(),
                        generisiPovisenTetaSignal()))
                .build();
    }

    private static GenerisanSignal generisiAlfaOdsutnoTetaIDeltaPoviseno() {
        return GenerisanSignal.builder()
                .signals(Arrays.asList(
                        generisiNormalanBetaSignal(),
                        generisiNormalanGamaSignal(),
                        generisiPovisenDeltaSignal(),
                        generisiPovisenTetaSignal()))
                .build();
    }
}
