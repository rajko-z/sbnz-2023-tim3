package com.ftn.sbnz2023tim3.service.repozitorijumi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PregledRepozitorijum extends JpaRepository<Pregled, Long> {
}
