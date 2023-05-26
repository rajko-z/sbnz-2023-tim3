package com.ftn.sbnz2023tim3.service.repozitorijumi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PregledRepozitorijum extends JpaRepository<Pregled, Long> {

    @Query("select p from Pregled p " +
           " left join fetch p.pacijent pp" +
           " left join fetch p.doktor d" +
           " left join fetch p.adhdUpitnik au" +
           " left join fetch p.nesanicaUpitnik nu" +
           " left join fetch p.alchajmerUpitnik aau" +
           " left join fetch p.epilepsijaUpitnik eu" +
           " where p.id = ?1")
    Pregled findByIdSaSvimPoljimaSemLekova(Long id);

    @Query("select p from Pregled p left join fetch p.pacijent pp where p.id = ?1")
    Pregled getPregledSaPacijentom(Long pregledId);


    @Query("select p from Pregled p" +
            " left join fetch p.pacijent pp" +
            " left join fetch p.doktor d" +
            " left join fetch p.adhdUpitnik au" +
            " left join fetch p.nesanicaUpitnik nu" +
            " left join fetch p.alchajmerUpitnik aau" +
            " left join fetch p.epilepsijaUpitnik eu" +
            " where p.doktor.email = ?1")
    ArrayList<Pregled> findAllByDoktorEmail(String email);

    @Query("select p from Pregled p" +
            " left join fetch p.pacijent pp" +
            " left join fetch p.doktor d" +
            " left join fetch p.adhdUpitnik au" +
            " left join fetch p.nesanicaUpitnik nu" +
            " left join fetch p.alchajmerUpitnik aau" +
            " left join fetch p.epilepsijaUpitnik eu" +
            " where p.pacijent.email = ?1")
    ArrayList<Pregled> findAllByPacijentEmail(String email);
}
