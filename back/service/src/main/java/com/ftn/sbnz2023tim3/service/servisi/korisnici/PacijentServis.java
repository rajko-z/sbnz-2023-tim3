package com.ftn.sbnz2023tim3.service.servisi.korisnici;

import com.ftn.sbnz2023tim3.model.modeli.dto.KorisnikDTO;
import com.ftn.sbnz2023tim3.service.konverteri.KorisnikDTOKonverter;
import com.ftn.sbnz2023tim3.service.repozitorijumi.PacijentRepozitorijum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacijentServis {

    private final PacijentRepozitorijum pacijentRepozitorijum;

    public List<KorisnikDTO> findAllPacijente() {
        return pacijentRepozitorijum.findAll()
                                    .stream()
                                    .map(KorisnikDTOKonverter::konvertuj)
                                    .collect(Collectors.toList());
    }
}
