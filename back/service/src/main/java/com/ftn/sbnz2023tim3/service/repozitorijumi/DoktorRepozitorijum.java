package com.ftn.sbnz2023tim3.service.repozitorijumi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DoktorRepozitorijum extends JpaRepository<Doktor, String> {

    @Query("select d from Doktor d" +
            " left join fetch d.trenutniPregled p" +
            " left join fetch p.adhdUpitnik a" +
            " left join fetch p.alchajmerUpitnik aa" +
            " left join fetch p.nesanicaUpitnik n" +
            " left join fetch p.epilepsijaUpitnik e" +
            " where d.email =? 1")
    Optional<Doktor> findByEmailWithPregledAndUpitnici(String email);
}
