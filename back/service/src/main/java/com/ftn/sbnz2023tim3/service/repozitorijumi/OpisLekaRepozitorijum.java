package com.ftn.sbnz2023tim3.service.repozitorijumi;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.OpisLeka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpisLekaRepozitorijum extends JpaRepository<OpisLeka, Long> {

    @Query("select distinct o from OpisLeka o left join fetch o.sastojci s where o.tipBolesti = ?1")
    List<OpisLeka> pronadjiOpiseLekovaSaSastojcimaPoTipuBolesti(TipBolesti tipBolesti);

    @Query("select o from OpisLeka o left join fetch o.dozvoljeniUzrasti d where o.id = ?1")
    OpisLeka pronadjiOpisLekaSaUzrastima(Long id);

    @Query("select o from OpisLeka o where o.naziv = ?1")
    OpisLeka pronadjiPoNazivu(String naziv);
}
