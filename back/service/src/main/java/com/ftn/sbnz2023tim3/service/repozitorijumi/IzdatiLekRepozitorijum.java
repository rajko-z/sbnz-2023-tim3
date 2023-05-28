package com.ftn.sbnz2023tim3.service.repozitorijumi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.IzdatLek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IzdatiLekRepozitorijum extends JpaRepository<IzdatLek, Long> {

    @Query("select distinct i from IzdatLek i" +
            " left join fetch i.opisLeka o" +
            " left join fetch o.sastojci s" +
            " where i.pregled.id = ?1")
    List<IzdatLek> pronadjiIzdateLekovePoIdjuPregleda(Long id);
}
