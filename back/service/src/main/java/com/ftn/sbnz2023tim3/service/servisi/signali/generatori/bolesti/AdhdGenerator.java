package com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;

import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.AlfaGenerator.generisiSnizenAlfaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.BetaGenerator.generisiPovisenBetaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.DeltaGenerator.generisiNormalanDeltaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.GamaGenerator.generisiNormalanGamaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.TetaGenerator.generisiNormalanTetaSignal;

public class AdhdGenerator {

    private AdhdGenerator() {}

    public static GenerisanSignal generisiAdhd() {
        return GenerisanSignal.builder()
                .alfaSignal(generisiSnizenAlfaSignal())
                .betaSignal(generisiPovisenBetaSignal())
                .gamaSignal(generisiNormalanGamaSignal())
                .deltaSignal(generisiNormalanDeltaSignal())
                .tetaSignal(generisiNormalanTetaSignal())
                .build();
    }
}
