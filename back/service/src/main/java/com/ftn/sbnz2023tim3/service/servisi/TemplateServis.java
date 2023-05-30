package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.dto.SignalDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.TipSignalaWrapper;
import com.ftn.sbnz2023tim3.model.modeli.dto.lekovi.OpisLekaTemplateDTO;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.DeoMozga;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjePacijenta;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.Uzrast;
import lombok.AllArgsConstructor;
import org.apache.maven.shared.invoker.*;
import org.drools.template.ObjectDataCompiler;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class TemplateServis {

    public void generisiPravilaZaOdredjivanjeTipaSignala() throws IOException, MavenInvocationException {
        InputStream template = new FileInputStream(
                "kjar/src/main/resources/rules/templates/signalTemplate.drt");

        List<SignalDTO> arguments = new ArrayList<>();
        arguments.add(new SignalDTO(5,15,40,60, Arrays.asList(DeoMozga.POTILJACNI, DeoMozga.TEMENI,  DeoMozga.FRONTALNI), StanjePacijenta.OPUSTENO_STANJE, TipSignala.ALFA));
        arguments.add(new SignalDTO(10,35,10,30, Arrays.asList(DeoMozga.TEMENI, DeoMozga.FRONTALNI), StanjePacijenta.POJACANA_AKTIVNOST_MOZGA, TipSignala.BETA));
        arguments.add(new SignalDTO(20,120,0,60, Arrays.asList(DeoMozga.POTILJACNI, DeoMozga.TEMENI, DeoMozga.FRONTALNI, DeoMozga.TEMPORALNI), StanjePacijenta.VISOKO_PROCESIRANJE_PODATAKA, TipSignala.GAMA));
        arguments.add(new SignalDTO(0,6,50,110, Arrays.asList(DeoMozga.POTILJACNI, DeoMozga.TEMENI, DeoMozga.FRONTALNI, DeoMozga.TEMPORALNI), StanjePacijenta.SAN, TipSignala.DELTA));
        arguments.add(new SignalDTO(2,10,60,80, Arrays.asList(DeoMozga.TEMENI, DeoMozga.TEMPORALNI), StanjePacijenta.NAPETOST, TipSignala.TETA));
        ObjectDataCompiler compiler = new ObjectDataCompiler();
        String drl = compiler.compile(arguments, template);

        FileOutputStream drlFile = new FileOutputStream(new File("kjar/src/main/resources/rules/signali/signal.drl"), false);
        drlFile.write(drl.getBytes());
        drlFile.close();

        invoke();
    }

    public void generisiPravilaSumiranjaPoSignalima() throws IOException {
        InputStream template = new FileInputStream(
                "kjar/src/main/resources/rules/signaliStavka/sumiranjePoSignalimaTemplate.drt");

        List<TipSignalaWrapper> arguments = new ArrayList<>();
        arguments.add(new TipSignalaWrapper(TipSignala.ALFA));
        arguments.add(new TipSignalaWrapper(TipSignala.BETA));
        arguments.add(new TipSignalaWrapper(TipSignala.GAMA));
        arguments.add(new TipSignalaWrapper(TipSignala.DELTA));
        arguments.add(new TipSignalaWrapper(TipSignala.TETA));
        ObjectDataCompiler compiler = new ObjectDataCompiler();
        String drl = compiler.compile(arguments, template);

        FileOutputStream drlFile = new FileOutputStream("kjar/src/main/resources/rules/signaliStavka/sumiranjePoSignalimaGen.drl", false);
        drlFile.write(drl.getBytes());
        drlFile.close();
    }

    public void generisiPravilaZaOdredjivanjeDozeLeka() throws IOException, MavenInvocationException {
        InputStream template = new FileInputStream(
                "kjar/src/main/resources/rules/preporukaLekova/opisDoze.drt");

        List<OpisLekaTemplateDTO> arguments = new ArrayList<>();
        arguments.add(new OpisLekaTemplateDTO("Methylphenidate-Ritalin", Uzrast.DETE, "Obično počinje sa 5 mg dva puta dnevno (pre doručka i ručka). Doza se može povećavati nedeljno za 5-10 mg/dan do maksimalno 60 mg/dan."));
        arguments.add(new OpisLekaTemplateDTO("Methylphenidate-Ritalin", Uzrast.ADOLESCENT, "Obično počinje sa 5 mg dva puta dnevno (pre doručka i ručka). Doza se može povećavati nedeljno za 5-10 mg/dan do maksimalno 60 mg/dan."));
        arguments.add(new OpisLekaTemplateDTO("Methylphenidate-Ritalin", Uzrast.ODRASTAO, "Obično počinje sa 5 mg dva puta dnevno (pre doručka i ručka). Doza se može povećavati nedeljno za 5-10 mg/dan do maksimalno 60 mg/dan."));

        arguments.add(new OpisLekaTemplateDTO("Amphetamine-Adderall", Uzrast.DETE, "Obično se započinje sa 5 mg jednom ili dva puta dnevno. Doza se može povećavati nedeljno za 5 mg/dan, do maksimalne doze od 30 mg/dan"));
        arguments.add(new OpisLekaTemplateDTO("Amphetamine-Adderall", Uzrast.ADOLESCENT, "Obično se započinje sa 10 mg jednom dnevno. Doza se može povećavati nedeljno za 10 mg/dan, do maksimalne doze od 40 mg/dan."));
        arguments.add(new OpisLekaTemplateDTO("Amphetamine-Adderall", Uzrast.ODRASTAO, "Obično se započinje sa 10 mg jednom dnevno. Doza se može povećavati nedeljno za 10 mg/dan, do maksimalne doze od 40 mg/dan."));

        arguments.add(new OpisLekaTemplateDTO("Atomoxetine-Strattera", Uzrast.DETE, "Obično se započinje sa 0.5 mg/kg/dan, povećavajući do ciljane doze od 1.2 mg/kg/dan nakon minimalno 3 dana. Maksimalna doza je 1.4 mg/kg/dan ili 100 mg/dan, u zavisnosti od toga koja je manja."));
        arguments.add(new OpisLekaTemplateDTO("Atomoxetine-Strattera", Uzrast.ADOLESCENT, "Obično se započinje sa 40 mg/dan, povećavajući do ciljane doze od 80 mg/dan nakon minimalno 3 dana. Maksimalna doza je 100 mg/dan."));
        arguments.add(new OpisLekaTemplateDTO("Atomoxetine-Strattera", Uzrast.ODRASTAO, "Obično se započinje sa 40 mg/dan, povećavajući do ciljane doze od 80 mg/dan nakon minimalno 3 dana. Maksimalna doza je 100 mg/dan."));

        arguments.add(new OpisLekaTemplateDTO("Guanfacine-Intuniv", Uzrast.DETE, " Obično se započinje sa 1 mg/dan, sa povećanjem doze od 1 mg nedeljno, do maksimalne doze od 4 mg/dan, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Guanfacine-Intuniv", Uzrast.ADOLESCENT, "Obično se započinje sa 1 mg/dan, sa povećanjem doze od 1 mg nedeljno, do maksimalne doze od 7 mg/dan, na osnovu odgovora i podnošljivosti."));

        arguments.add(new OpisLekaTemplateDTO("Clonidine-Kapvay", Uzrast.DETE, "Obično se započinje sa 0.1 mg/dan, sa povećanjem doze od 0.1 mg nedeljno, do maksimalne doze od 0.4 mg/dan, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Clonidine-Kapvay", Uzrast.ADOLESCENT, "Obično se započinje sa 0.1 mg/dan, sa povećanjem doze od 0.1 mg nedeljno, do maksimalne doze od 0.4 mg/dan, na osnovu odgovora i podnošljivosti."));



        arguments.add(new OpisLekaTemplateDTO("Donepezil-Aricept", Uzrast.DETE, "5-10 mg jednom dnevno, po mogućstvu uveče"));
        arguments.add(new OpisLekaTemplateDTO("Donepezil-Aricept", Uzrast.ADOLESCENT, "5-10 mg jednom dnevno, po mogućstvu uveče"));
        arguments.add(new OpisLekaTemplateDTO("Donepezil-Aricept", Uzrast.ODRASTAO, "10-23 mg jednom dnevno, po mogućstvu uveče"));

        arguments.add(new OpisLekaTemplateDTO("Memantine-Namenda", Uzrast.DETE, "Početna doza je 3 mg jednom dnevno, postepeno se povećava na 10 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Memantine-Namenda", Uzrast.ADOLESCENT, "Početna doza je 5 mg jednom dnevno, postepeno se povećava na 10 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Memantine-Namenda", Uzrast.ODRASTAO, " Početna doza je 5 mg jednom dnevno, postepeno se povećava na 10 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));

        arguments.add(new OpisLekaTemplateDTO("Rivastigmine-Exelon", Uzrast.DETE, "Početna doza je 1.5 mg dva puta dnevno, postepeno se povećava na 6 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Rivastigmine-Exelon", Uzrast.ADOLESCENT, "Početna doza je 1.5 mg dva puta dnevno, postepeno se povećava na 6 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Rivastigmine-Exelon", Uzrast.ODRASTAO, "Početna doza je 1.5 mg dva puta dnevno, postepeno se povećava na 6 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));

        arguments.add(new OpisLekaTemplateDTO("Galantamine-Razadyne", Uzrast.DETE, "Početna doza je 4 mg dva puta dnevno, postepeno se povećava na 12 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Galantamine-Razadyne", Uzrast.ADOLESCENT, "Početna doza je 4 mg dva puta dnevno, postepeno se povećava na 12 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Galantamine-Razadyne", Uzrast.ODRASTAO, "Početna doza je 4 mg dva puta dnevno, postepeno se povećava na 12 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));

        arguments.add(new OpisLekaTemplateDTO("Combination therapy-Namzaric", Uzrast.DETE, " Početna doza je 2.5 mg dva puta dnevno, postepeno se povećava na 10 mg dva puta dnevno, na osnovu odgovora i podnošljivosti"));
        arguments.add(new OpisLekaTemplateDTO("Combination therapy-Namzaric", Uzrast.ADOLESCENT, "Početna doza je 2.5 mg dva puta dnevno, postepeno se povećava na 10 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Combination therapy-Namzaric", Uzrast.ODRASTAO, "Početna doza je 2.5 mg dva puta dnevno, postepeno se povećava na 12 mg dva puta dnevno, na osnovu odgovora i podnošljivosti."));



        arguments.add(new OpisLekaTemplateDTO("Zolpidem-Ambien", Uzrast.ADOLESCENT, "5 mg za žene, 5-10 mg za muškarce, uzeti jednom dnevno neposredno pre spavanja."));
        arguments.add(new OpisLekaTemplateDTO("Zolpidem-Ambien", Uzrast.ODRASTAO, "5 mg za žene, 5-10 mg za muškarce, uzeti jednom dnevno neposredno pre spavanja."));

        arguments.add(new OpisLekaTemplateDTO("Eszopiclone-Lunesta", Uzrast.ADOLESCENT, "Početna doza je 1 mg, uzeta jednom dnevno neposredno pre spavanja; može se povećati na 2-3 mg na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Eszopiclone-Lunesta", Uzrast.ODRASTAO, "Početna doza je 1 mg, uzeta jednom dnevno neposredno pre spavanja; može se povećati na 2-3 mg na osnovu odgovora i podnošljivosti."));

        arguments.add(new OpisLekaTemplateDTO("Zaleplon-Sonata", Uzrast.ADOLESCENT, "Početna doza je 5-10 mg, uzeta jednom dnevno neposredno pre spavanja; doza se može povećati na 20 mg na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Zaleplon-Sonata", Uzrast.ODRASTAO, "Početna doza je 5-10 mg, uzeta jednom dnevno neposredno pre spavanja; doza se može povećati na 20 mg na osnovu odgovora i podnošljivosti."));

        arguments.add(new OpisLekaTemplateDTO("Ramelteon-Rozerem", Uzrast.ADOLESCENT, "8 mg, uzet jednom dnevno neposredno pre spavanja."));
        arguments.add(new OpisLekaTemplateDTO("Ramelteon-Rozerem", Uzrast.ODRASTAO, "8 mg, uzet jednom dnevno neposredno pre spavanja."));

        arguments.add(new OpisLekaTemplateDTO("Trazodone-Desyrel", Uzrast.ADOLESCENT, "25-100 mg, uzet jednom dnevno neposredno pre spavanja; doze mogu biti različite."));
        arguments.add(new OpisLekaTemplateDTO("Trazodone-Desyrel", Uzrast.ODRASTAO, "25-100 mg, uzet jednom dnevno neposredno pre spavanja; doze mogu biti različite."));



        arguments.add(new OpisLekaTemplateDTO("Levetiracetam-Keppra", Uzrast.DETE, "Početna doza je 500 mg dva puta dnevno, uz moguće povećanje do maksimalne doze od 2,000 mg/dan, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Levetiracetam-Keppra", Uzrast.ADOLESCENT, "Početna doza je 500 mg dva puta dnevno, uz moguće povećanje do maksimalne doze od 3,000 mg/dan, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Levetiracetam-Keppra", Uzrast.ODRASTAO, "Početna doza je 500 mg dva puta dnevno, uz moguće povećanje do maksimalne doze od 3,000 mg/dan, na osnovu odgovora i podnošljivosti."));

        arguments.add(new OpisLekaTemplateDTO("Lamotrigine-Lamictal", Uzrast.DETE, "Doziranje je kompleksno i varira u zavisnosti od istovremenih lekova i individualnog odgovora."));
        arguments.add(new OpisLekaTemplateDTO("Lamotrigine-Lamictal", Uzrast.ADOLESCENT, "Doziranje je kompleksno i varira u zavisnosti od istovremenih lekova i individualnog odgovora."));
        arguments.add(new OpisLekaTemplateDTO("Lamotrigine-Lamictal", Uzrast.ODRASTAO, "Doziranje je kompleksno i varira u zavisnosti od istovremenih lekova i individualnog odgovora."));

        arguments.add(new OpisLekaTemplateDTO("Carbamazepine-Tegretol", Uzrast.DETE, "Početna doza je 100-150 mg dva puta dnevno, uz moguće povećanje do maksimalne doze od 1,000 mg/dan, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Carbamazepine-Tegretol", Uzrast.ADOLESCENT, "Početna doza je 100-200 mg dva puta dnevno, uz moguće povećanje do maksimalne doze od 1,200 mg/dan, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Carbamazepine-Tegretol", Uzrast.ODRASTAO, "Početna doza je 100-200 mg dva puta dnevno, uz moguće povećanje do maksimalne doze od 1,200 mg/dan, na osnovu odgovora i podnošljivosti."));

        arguments.add(new OpisLekaTemplateDTO("Valproic acid-Depakote", Uzrast.DETE, "Početna doza je 7-12 mg/kg/dan, uz moguće povećanje do maksimalne doze od 50 mg/kg/dan, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Valproic acid-Depakote", Uzrast.ADOLESCENT, "Početna doza je 10-15 mg/kg/dan, uz moguće povećanje do maksimalne doze od 55 mg/kg/dan, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Valproic acid-Depakote", Uzrast.ODRASTAO, "Početna doza je 10-18 mg/kg/dan, uz moguće povećanje do maksimalne doze od 60 mg/kg/dan, na osnovu odgovora i podnošljivosti."));

        arguments.add(new OpisLekaTemplateDTO("Topiramate-Topamax", Uzrast.DETE, "Početna doza je 20-45 mg jednom dnevno, uz moguće povećanje do maksimalne doze od 350 mg/dan, na osnovu odgovora i podnošljivosti."));
        arguments.add(new OpisLekaTemplateDTO("Topiramate-Topamax", Uzrast.ADOLESCENT, "Početna doza je 25-50 mg jednom dnevno, uz moguće povećanje do maksimalne doze od 400 mg/dan, na osnovu odgovora i podnošljivosti"));
        arguments.add(new OpisLekaTemplateDTO("Topiramate-Topamax", Uzrast.ODRASTAO, "Početna doza je 25-50 mg jednom dnevno, uz moguće povećanje do maksimalne doze od 400 mg/dan, na osnovu odgovora i podnošljivosti."));


        ObjectDataCompiler compiler = new ObjectDataCompiler();
        String drl = compiler.compile(arguments, template);

        FileOutputStream drlFile = new FileOutputStream("kjar/src/main/resources/rules/preporukaLekova/odredjivanjeDoze.drl", false);
        drlFile.write(drl.getBytes());
        drlFile.close();

    }

    private void invoke() throws MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("kjar/pom.xml"));
        request.setGoals(Arrays.asList("clean", "install"));

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File("/opt/homebrew/Cellar/maven/3.9.1/libexec"));
        invoker.execute(request);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
