package com.ftn.sbnz2023tim3.service.servisi.signali;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;
import com.ftn.sbnz2023tim3.model.modeli.dto.SignalDTO;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.*;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Doktor;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Pacijent;
import com.ftn.sbnz2023tim3.service.izuzeci.BadRequestException;
import com.ftn.sbnz2023tim3.service.konfiguracija.DRoolsKonfiguracija;
import com.ftn.sbnz2023tim3.service.servisi.PregledServis;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.DoktorServis;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti.AdhdGenerator;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti.AlchajmerGenerator;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti.EpilepsijaGenerator;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.bolesti.NesanicaGenerator;
import com.ftn.sbnz2023tim3.service.servisi.signali.generatori.signala.*;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.maven.shared.invoker.*;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class SignalServis {

    private final DoktorServis doktorServis;

    private final PregledServis pregledServis;

    private final DRoolsKonfiguracija dRoolsKonfiguracija;

    public GenerisanSignal generisiEegSignal() throws MavenInvocationException, IOException {
        //5,15,40,60,"potiljacniRezanj, temeniRezanj, frontalniRezanj", "opustenoStanje", alfa
        SignalDTO signalDTO = new SignalDTO(5,15,40,60, DeoMozga.POTILJACNI, StanjePacijenta.OPUSTENO_STANJE, TipSignala.ALFA);
        generisiPravilaIzTemplejta(signalDTO);
        Doktor doktor = doktorServis.getTrenutnoUlogovanDoktorSaPregledomIUpitnicima();
        if (doktor.getTrenutniPregled() == null) {
            throw new BadRequestException("Nemate trenutni pregled");
        }
        Pregled pregled = doktor.getTrenutniPregled();
        if (!StanjeEEGPregleda.U_TOKU.equals(pregled.getStanjeEEGPregleda())) {
            throw new BadRequestException("EEG pregled nije zapocet");
        }
        Pacijent pacijent = pregledServis.getPacijentPregleda(pregled.getId());
        boolean generisiNesanicu = !pacijent.getUzrast().equals(Uzrast.DETE);

        if (pregled.getAdhdUpitnik() == null &&
            pregled.getAlchajmerUpitnik() == null &&
            pregled.getNesanicaUpitnik() == null &&
            pregled.getEpilepsijaUpitnik() == null) {
            GenerisanSignal generisanSignal = generisiRavnomeranRandomSignal(generisiNesanicu);
            insertIntoKSession(generisanSignal);
            return generisanSignal;
        }
        GenerisanSignal generisanSignal = generisiRandomSignalNaOsnovuProcenataUpitnika(pregled, generisiNesanicu);
        insertIntoKSession(generisanSignal);
        return generisanSignal;
    }

    public void generisiPravilaIzTemplejta(SignalDTO dto) throws IOException, MavenInvocationException {
        InputStream template = new FileInputStream(
                "kjar/src/main/resources/rules/signali/templates/signal.drt");

        List<SignalDTO> arguments = new ArrayList<>();
        arguments.add(new SignalDTO(dto.getDonjaFrekvencija(), dto.getGornjaFrekvencija(), dto.getDonjaAmplituda(), dto.getGornjaAmplituda(), dto.getPredeliMozga(), dto.getStanjePacijenta(), dto.getTipSignala()));
        ObjectDataCompiler compiler = new ObjectDataCompiler();
        String drl = compiler.compile(arguments, template);

        FileOutputStream drlFile = new FileOutputStream(new File("kjar/src/main/resources/rules/signali/signal.drl"), false);
        drlFile.write(drl.getBytes());
        drlFile.close();

        invoke();
    }

    private void invoke() throws MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("kjar/pom.xml"));
        request.setGoals(Arrays.asList("clean", "install"));

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("M2_HOME")));
        invoker.execute(request);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void insertIntoKSession(GenerisanSignal generisanSignal) {
        KieSession ksession = dRoolsKonfiguracija.getOrCreateKieSession("signaliKS");
        ksession.insert(generisanSignal.getAlfaSignal());
        ksession.insert(generisanSignal.getBetaSignal());
        ksession.insert(generisanSignal.getTetaSignal());
        ksession.insert(generisanSignal.getDeltaSignal());
        ksession.insert(generisanSignal.getGamaSignal());
        ksession.fireAllRules();
    }

    private GenerisanSignal generisiRandomSignalNaOsnovuProcenataUpitnika(Pregled pregled, boolean generisiNesanicu) {
        List<Pair<TipBolesti, Double>> procenti = getProcentiUpitnikaIzPregleda(pregled, generisiNesanicu);

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

    private List<Pair<TipBolesti, Double>> getProcentiUpitnikaIzPregleda(Pregled pregled, boolean generisiNesanicu) {
        List<Pair<TipBolesti, Double>> procenti = new ArrayList<>();
        procenti.add(new ImmutablePair<>(TipBolesti.ADHD, pregled.getAdhdProcenat()));
        procenti.add(new ImmutablePair<>(TipBolesti.ALCHAJMER, pregled.getAlchajmerProcenat()));
        procenti.add(new ImmutablePair<>(TipBolesti.EPILEPSIJA, pregled.getEpilepsijaProcenat()));
        if (generisiNesanicu) {
            procenti.add(new ImmutablePair<>(TipBolesti.NESANICA, pregled.getNesanicaProcenat()));
        }
        return procenti;
    }

    private GenerisanSignal generisiRavnomeranRandomSignal(boolean generisiNesanicu) {
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
                .alfaSignal(AlfaGenerator.generisiNormalanAlfaSignal())
                .betaSignal(BetaGenerator.generisiNormalanBetaSignal())
                .gamaSignal(GamaGenerator.generisiNormalanGamaSignal())
                .deltaSignal(DeltaGenerator.generisiNormalanDeltaSignal())
                .tetaSignal(TetaGenerator.generisiNormalanTetaSignal())
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
