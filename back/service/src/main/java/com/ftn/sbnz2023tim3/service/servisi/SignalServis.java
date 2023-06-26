package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;
import com.ftn.sbnz2023tim3.service.konfiguracija.DRoolsKonfiguracija;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignalServis {
    private final DRoolsKonfiguracija dRoolsKonfiguracija;
    private final SimpMessagingTemplate simpMessagingTemplate;


    public void preuzmiSignal(GenerisanSignal generisanSignal) {
        insertIntoKSession(generisanSignal);
        this.simpMessagingTemplate.convertAndSend("/notifikacija", generisanSignal);
    }

    private void insertIntoKSession(GenerisanSignal generisanSignal) {
        KieSession ksession = dRoolsKonfiguracija.getOrCreateKieSession("signaliKS");
        generisanSignal.getSignals().forEach(ksession::insert);
        ksession.fireAllRules();

        KieSession ksessionStavka = dRoolsKonfiguracija.getOrCreateKieSession("signaliStavkaKS");
        generisanSignal.getSignals().forEach(ksessionStavka::insert);
        ksessionStavka.fireAllRules();
    }
}