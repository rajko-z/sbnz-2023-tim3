package com.ftn.sbnz.device.servisi.generatori.bolesti;

import com.ftn.sbnz.device.model.GenerisanSignal;

import java.util.Arrays;

import static com.ftn.sbnz.device.servisi.generatori.signala.AlfaGenerator.generisiNormalanAlfaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.BetaGenerator.generisiPovisenBetaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.DeltaGenerator.generisiNormalanDeltaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.GamaGenerator.generisiPovisenGamaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.TetaGenerator.generisiNormalanTetaSignal;

public class EpilepsijaGenerator {

    private EpilepsijaGenerator() {}

    public static GenerisanSignal generisiEpilepsija() {
        return GenerisanSignal.builder()
                .signals(Arrays.asList(
                        generisiNormalanAlfaSignal(),
                        generisiPovisenBetaSignal(),
                        generisiPovisenGamaSignal(),
                        generisiNormalanDeltaSignal(),
                        generisiNormalanTetaSignal()
                ))
                .build();
    }
}
