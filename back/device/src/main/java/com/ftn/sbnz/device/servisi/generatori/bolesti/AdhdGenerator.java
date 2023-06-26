package com.ftn.sbnz.device.servisi.generatori.bolesti;

import com.ftn.sbnz.device.model.GenerisanSignal;

import java.util.Arrays;

import static com.ftn.sbnz.device.servisi.generatori.signala.AlfaGenerator.generisiSnizenAlfaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.BetaGenerator.generisiPovisenBetaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.DeltaGenerator.generisiNormalanDeltaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.GamaGenerator.generisiNormalanGamaSignal;
import static com.ftn.sbnz.device.servisi.generatori.signala.TetaGenerator.generisiNormalanTetaSignal;


public class AdhdGenerator {

    private AdhdGenerator() {}

    public static GenerisanSignal generisiAdhd() {
        return GenerisanSignal.builder()
                .signals(Arrays.asList(
                        generisiSnizenAlfaSignal(),
                        generisiPovisenBetaSignal(),
                        generisiNormalanGamaSignal(),
                        generisiNormalanDeltaSignal(),
                        generisiNormalanTetaSignal()
                ))
                .build();
    }
}
