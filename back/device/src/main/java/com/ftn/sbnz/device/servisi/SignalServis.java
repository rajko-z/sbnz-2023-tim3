package com.ftn.sbnz.device.servisi;

import com.ftn.sbnz.device.model.GenerisanSignal;
import com.ftn.sbnz.device.model.enumeracije.TipBolesti;
import com.ftn.sbnz.device.servisi.generatori.bolesti.AdhdGenerator;
import com.ftn.sbnz.device.servisi.generatori.bolesti.AlchajmerGenerator;
import com.ftn.sbnz.device.servisi.generatori.bolesti.EpilepsijaGenerator;
import com.ftn.sbnz.device.servisi.generatori.bolesti.NesanicaGenerator;
import com.ftn.sbnz.device.servisi.generatori.signala.*;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class SignalServis {

    public GenerisanSignal proceniKojaBolestImaNajveciProcenat(List<Pair<TipBolesti, Double>> procenti){
        procenti.sort(Comparator.comparing(p -> -p.getRight()));

        int povecanProcenat = (int) (procenti.get(0).getRight()*100) + 15;

        Pair<TipBolesti, Integer> najvisaBolest = new ImmutablePair<>(procenti.get(0).getLeft(), povecanProcenat);

        return generisiSignalSaVisokimProcentomBolesti(najvisaBolest, procenti.get(1).getLeft());
    }

    private GenerisanSignal generisiSignalSaVisokimProcentomBolesti(Pair<TipBolesti, Integer> bolest, TipBolesti sum) {
        int random = RandomUtils.generisiRandomBrojIzmedju(1,100);

        int granica = bolest.getRight() >= 80 ? 80 : bolest.getRight();
        if (granica >= random) {
            return generisiBolestNaOsnovuTipa(bolest.getLeft());
        }

        random = RandomUtils.generisiRandomBrojIzmedju(1,2);
        if (random == 1) {
            return generisiZdravSignal();
        }
        return generisiBolestNaOsnovuTipa(sum);
    }


    public GenerisanSignal generisiRavnomeranRandomSignal(boolean generisiNesanicu) {
        int random = RandomUtils.generisiRandomBrojIzmedju(0,9);

        if (random == 0 || random == 1) {
            return generisiZdravSignal();
        }
        if (random == 2 || random == 3) {
            return AdhdGenerator.generisiAdhd();
        }
        if (random == 4 || random == 5) {
            return AlchajmerGenerator.generisiAlchajmer();
        }
        if (random == 6 || random == 7) {
            return EpilepsijaGenerator.generisiEpilepsija();
        }
        if (generisiNesanicu) {
            return NesanicaGenerator.generisiNesanica();
        } else {
            return generisiZdravSignal();
        }
    }

    private GenerisanSignal generisiZdravSignal() {
        return GenerisanSignal.builder()
                .signals(Arrays.asList(
                        AlfaGenerator.generisiNormalanAlfaSignal(),
                        BetaGenerator.generisiNormalanBetaSignal(),
                        GamaGenerator.generisiNormalanGamaSignal(),
                        DeltaGenerator.generisiNormalanDeltaSignal(),
                        TetaGenerator.generisiNormalanTetaSignal()
                ))
                .build();
    }

    private GenerisanSignal generisiBolestNaOsnovuTipa(TipBolesti tipBolesti) {
        switch (tipBolesti) {
            case ADHD: return AdhdGenerator.generisiAdhd();
            case ALCHAJMER: return AlchajmerGenerator.generisiAlchajmer();
            case EPILEPSIJA: return EpilepsijaGenerator.generisiEpilepsija();
            default: return NesanicaGenerator.generisiNesanica();
        }
    }

}
