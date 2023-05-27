package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipBolesti;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.IzdatLek;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.OpisLeka;
import com.ftn.sbnz2023tim3.model.modeli.tabele.lekovi.SastojakLeka;
import com.ftn.sbnz2023tim3.service.repozitorijumi.IzdatiLekRepozitorijum;
import com.ftn.sbnz2023tim3.service.repozitorijumi.OpisLekaRepozitorijum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LekoviServis {

    private final IzdatiLekRepozitorijum izdatiLekRepozitorijum;

    private final OpisLekaRepozitorijum opisLekaRepozitorijum;

    public List<IzdatLek> getIzdatiLekoviPoIdjuPregleda(Long pregledId) {
        return izdatiLekRepozitorijum.pronadjiIzdateLekovePoIdjuPregleda(pregledId);
    }

    public List<String> getSastojciZaTipBolesti(TipBolesti tipBolesti) {
        List<String> sastojci = new ArrayList<>();
        List<OpisLeka> lekovi = opisLekaRepozitorijum.pronadjiOpiseLekovaPoTipuBolesti(tipBolesti);
        lekovi.forEach(lek -> sastojci.addAll(lek.getSastojci().stream().map(SastojakLeka::getNaziv).collect(Collectors.toList())));
        return sastojci;
    }
}
