package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.dto.KorisnikSaTokenom;
import com.ftn.sbnz2023tim3.model.modeli.dto.PrijavaDTO;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Korisnik;
import com.ftn.sbnz2023tim3.service.izuzeci.NevalidniKredencijali;
import com.ftn.sbnz2023tim3.service.konverteri.KorisnikDTOKonverter;
import com.ftn.sbnz2023tim3.service.pomocneKlase.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutentifikacijaServis {

    private final TokenUtils tokenUtils;

    private final AuthenticationManager authenticationManager;

    public KorisnikSaTokenom kreirajAutentifikacioniToken(PrijavaDTO prijavaDTO) {
        try
        {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(prijavaDTO.getEmail(), prijavaDTO.getLozinka()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            Korisnik user = (Korisnik) authentication.getPrincipal();
            String jwt = tokenUtils.generateToken(user.getUsername(), user.getRola());

            return KorisnikDTOKonverter.konvertujSaTokenom(user, jwt);
        }
        catch (BadCredentialsException ex) {
            throw new NevalidniKredencijali("Nevalidni kredencijali");
        }
    }
}
