package com.ftn.sbnz.device.zakazivaci;

import com.ftn.sbnz.device.model.GenerisanSignal;
import com.ftn.sbnz.device.model.dto.InfoZaGenerisanSignal;
import com.ftn.sbnz.device.servisi.ServiceIntegrationService;
import com.ftn.sbnz.device.servisi.SignalServis;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class SignalScheduler {
    private ScheduledExecutorService scheduler;
    private final SignalServis signalServis;
    private final ServiceIntegrationService serviceIntegrationService;

    public SignalScheduler(SignalServis signalServis, ServiceIntegrationService serviceIntegrationService) {
        this.signalServis = signalServis;
        this.serviceIntegrationService = serviceIntegrationService;
    }

    public void startScheduler(InfoZaGenerisanSignal dto) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> runScheduledTask(dto), 0, 1, TimeUnit.SECONDS);
    }

    public void stopScheduler() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }

    private void runScheduledTask(InfoZaGenerisanSignal dto) {
        GenerisanSignal generisanSignal;
        if (dto.isUzmiUObzirUpitnike()) {
            generisanSignal = signalServis.proceniKojaBolestImaNajveciProcenat(dto.getProcenti());
        } else {
            generisanSignal = signalServis.generisiRavnomeranRandomSignal(dto.isUzmiUObzirNesanicu());
        }

        generisanSignal.getSignals().forEach(s -> s.setPregled(dto.getPregled()));

        serviceIntegrationService.sendToServiceApp(generisanSignal, "/signali/preuzmi-signal", HttpMethod.POST);
    }
}
