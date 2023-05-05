package com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.adhd;

import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.adhd.AdhdPitanje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdhdPitanjeRepozitorijum extends JpaRepository<AdhdPitanje, Long> {

    List<AdhdPitanje> findAllByOrderByRedniBrojAsc();
}
