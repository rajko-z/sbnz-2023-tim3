package com.ftn.sbnz2023tim3.service.konfiguracija;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class DRoolsKonfiguracija {
    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks
                .newKieContainer(ks.newReleaseId("com.ftn.sbnz", "kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(1000);
        return kContainer;
    }

    @Bean
    public Map<String, KieSession> kieSessionsMap() {
        return new ConcurrentHashMap<>();
    }

    public KieSession getOrCreateKieSession(String kieSessionName) {
        return kieSessionsMap().computeIfAbsent(kieSessionName, kieContainer()::newKieSession);
    }

    public void clearKieSession(KieSession kieSession) {
        for (FactHandle factHandle : kieSession.getFactHandles()) {
            kieSession.retract(factHandle);
        }
    }


}
