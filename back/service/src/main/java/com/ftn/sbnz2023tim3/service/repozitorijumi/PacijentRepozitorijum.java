package com.ftn.sbnz2023tim3.service.repozitorijumi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PacijentRepozitorijum extends JpaRepository<Pacijent, String> {

    @Query("select p from Pacijent p" +
            " left join fetch p.trenutniPregled pr" +
            " left join fetch p.pregledi pp" +
            " where p.email =? 1")
    Optional<Pacijent> findByEmailWithPregledAndPregledHistory(String pacijentEmail);
}
