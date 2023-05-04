package com.ftn.sbnz2023tim3.service.repozitorijumi.upitnici.nesanica;

import com.ftn.sbnz2023tim3.model.modeli.tabele.upitnici.nesanica.NesanicaPitanje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NesanicaPitanjeRepozitorijum extends JpaRepository<NesanicaPitanje, Long> {
}
