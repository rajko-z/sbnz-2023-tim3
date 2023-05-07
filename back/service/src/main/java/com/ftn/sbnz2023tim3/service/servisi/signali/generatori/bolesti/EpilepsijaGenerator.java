package com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;

import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.AlfaGenerator.generisiNormalanAlfaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.BetaGenerator.generisiPovisenBetaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.DeltaGenerator.generisiNormalanDeltaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.GamaGenerator.generisiPovisenGamaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.TetaGenerator.generisiNormalanTetaSignal;

public class EpilepsijaGenerator {

    private EpilepsijaGenerator() {}

    public static GenerisanSignal generisiEpilepsija() {
        return GenerisanSignal.builder()
                .alfaSignal(generisiNormalanAlfaSignal())
                .betaSignal(generisiPovisenBetaSignal())
                .gamaSignal(generisiPovisenGamaSignal())
                .deltaSignal(generisiNormalanDeltaSignal())
                .tetaSignal(generisiNormalanTetaSignal())
                .build();
    }
}
