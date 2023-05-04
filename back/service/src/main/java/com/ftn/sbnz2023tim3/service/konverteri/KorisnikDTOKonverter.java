package com.ftn.sbnz2023tim3.service.konverteri;


import com.ftn.sbnz2023tim3.model.modeli.dto.KorisnikDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.KorisnikSaTokenom;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Korisnik;

public class KorisnikDTOKonverter {

    private KorisnikDTOKonverter() { }

    public static KorisnikDTO konvertuj(Korisnik user) {
        return KorisnikDTO.builder()
                .email(user.getEmail())
                .ime(user.getIme())
                .prezime(user.getPrezime())
                .brojGodina(user.getBrojGodina())
                .brojTelefona(user.getBrojTelefona())
                .rola(user.getRola().getNaziv())
                .build();
    }

    public static KorisnikSaTokenom konvertujSaTokenom(Korisnik user, String token) {
        return KorisnikSaTokenom.builder()
                .korisnik(konvertuj(user))
                .token(token)
                .build();
    }
}
