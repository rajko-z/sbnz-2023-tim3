package com.ftn.sbnz2023tim3.service.repozitorijumi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolaRepozitorijum extends JpaRepository<Role, Long> {

    List<Role> findByNaziv(String naziv);
}
