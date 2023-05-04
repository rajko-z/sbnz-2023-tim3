package com.ftn.sbnz2023tim3.service.repozitorijumi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KorisnikRepozitorijum extends JpaRepository<Korisnik, String> {

    Optional<Korisnik> findByEmail(String email);
}
