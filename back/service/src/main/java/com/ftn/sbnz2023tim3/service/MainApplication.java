package com.ftn.sbnz2023tim3.service;

import com.ftn.sbnz2023tim3.service.servisi.TemplateServis;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication(scanBasePackages = { "com.ftn.sbnz2023tim3.model", "com.ftn.sbnz2023tim3.kjar","com.ftn.sbnz2023tim3.service" })
@EntityScan(basePackages = "com.ftn.sbnz2023tim3.model.modeli.tabele")
@EnableAsync
public class MainApplication {

	@Autowired
	private TemplateServis templateServis;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@PostConstruct
	private void init() throws MavenInvocationException, IOException {
		//templateServis.generisiPravilaZaOdredjivanjeTipaSignala();
		//templateServis.generisiPravilaZaOdredjivanjeDozeLeka();
		//templateServis.generisiPravilaSumiranjaPoSignalima();
	}

}

