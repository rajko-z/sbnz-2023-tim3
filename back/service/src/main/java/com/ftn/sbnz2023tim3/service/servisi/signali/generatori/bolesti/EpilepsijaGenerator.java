package com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;

import java.util.Arrays;

import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.AlfaGenerator.generisiNormalanAlfaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.BetaGenerator.generisiPovisenBetaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.DeltaGenerator.generisiNormalanDeltaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.GamaGenerator.generisiPovisenGamaSignal;
import static com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.TetaGenerator.generisiNormalanTetaSignal;

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
