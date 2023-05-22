package com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.ftn.sbnz2023tim3.service.servisi.signali.RandomUtils.generisiRandomBrojIzmedju;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.AlfaGenerator.generisiSnizenAlfaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.BetaGenerator.generisiNormalanBetaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.DeltaGenerator.generisiPovisenDeltaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.GamaGenerator.generisiNormalanGamaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.TetaGenerator.generisiPovisenTetaSignal;

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
