package com.ftn.sbnz2023tim3.service.servisi.korisnici;

import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Korisnik;
import com.ftn.sbnz2023tim3.service.repozitorijumi.KorisnikRepozitorijum;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class KorisnikServis implements UserDetailsService {

    private final KorisnikRepozitorijum korisnikRepozitorijum;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Korisnik> user = korisnikRepozitorijum.findByEmail(username);
        if (user.isPresent())
            return user.get();
        throw new UsernameNotFoundException("Korisnik sa emailom: " + username + " nije pronadjen");
    }
}
