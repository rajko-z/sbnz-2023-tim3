package com.ftn.sbnz2023tim3.service.repozitorijumi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacijentRepozitorijum extends JpaRepository<Pacijent, String> {

}
