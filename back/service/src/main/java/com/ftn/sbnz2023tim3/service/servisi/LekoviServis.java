package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.IzdatLek;
import com.ftn.sbnz2023tim3.service.repozitorijumi.IzdatiLekRepozitorijum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class LekoviServis {

    private final IzdatiLekRepozitorijum izdatiLekRepozitorijum;

    public List<IzdatLek> getIzdatiLekoviPoIdjuPregleda(Long pregledId) {
        return izdatiLekRepozitorijum.pronadjiIzdateLekovePoIdjuPregleda(pregledId);
    }
}
