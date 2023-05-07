package com.ftn.sbnz2023tim3.service.konverteri;

import com.ftn.sbnz2023tim3.model.modeli.dto.lekovi.IzdatLekDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.lekovi.OpisLekaDTO;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.IzdatLek;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.OpisLeka;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.SastojakLeka;

import java.util.stream.Collectors;

public class LekoviDTOKonverter {

    private LekoviDTOKonverter() {}

    public static IzdatLekDTO konvertujIzdatLek(IzdatLek izdatLek) {
        return IzdatLekDTO.builder()
                .opisLeka(konvertujOpisLeka(izdatLek.getOpisLeka()))
                .opisDoze(izdatLek.getOpisDoze())
                .build();
    }

    public static OpisLekaDTO konvertujOpisLeka(OpisLeka opisLeka) {
        return OpisLekaDTO.builder()
                .naziv(opisLeka.getNaziv())
                .tipBolesti(opisLeka.getTipBolesti())
                .zaBlaguBolest(opisLeka.isZaBlaguBolest())
                .zaSrednjuBolest(opisLeka.isZaSrednjuBolest())
                .zaTeskuBolest(opisLeka.isZaTeskuBolest())
                .sastojci(opisLeka.getSastojci().stream().map(SastojakLeka::getNaziv).collect(Collectors.toList()))
                .dozvoljeniUzrasti(opisLeka.getDozvoljeniUzrasti())
                .build();
    }
}
