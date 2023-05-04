package com.ftn.sbnz2023tim3.service.servisi.korisnici;

import com.ftn.sbnz2023tim3.model.modeli.dto.KorisnikDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.NoviPacijentDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.PrijavaDTO;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Pacijent;
import com.ftn.sbnz2023tim3.service.izuzeci.BadRequestException;
import com.ftn.sbnz2023tim3.service.konverteri.KorisnikDTOKonverter;
import com.ftn.sbnz2023tim3.service.repozitorijumi.PacijentRepozitorijum;
import com.ftn.sbnz2023tim3.service.repozitorijumi.RolaRepozitorijum;
import com.ftn.sbnz2023tim3.service.servisi.EmailServis;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacijentServis {

    private final PacijentRepozitorijum pacijentRepozitorijum;

    private final RolaRepozitorijum rolaRepozitorijum;

    private final EmailServis emailServis;

    private final PasswordEncoder enkoderLozinke;

    public List<KorisnikDTO> findAllPacijente() {
        return pacijentRepozitorijum.findAll()
                                    .stream()
                                    .map(KorisnikDTOKonverter::konvertuj)
                                    .collect(Collectors.toList());
    }

    public Optional<Pacijent> findPacijentByEmail(String email) {
        return pacijentRepozitorijum.findById(email);
    }

    public void addPacijent(NoviPacijentDTO pacijent) {
        if (pacijentRepozitorijum.findById(pacijent.getEmail()).isPresent()) {
            throw new BadRequestException("Pacijent sa emailom: " + pacijent.getEmail() + " vec postoji");
        }
        Pacijent p = new Pacijent();
        p.setEmail(pacijent.getEmail());
        p.setIme(pacijent.getIme());
        p.setPrezime(pacijent.getPrezime());
        p.setDatumRodjenja(pacijent.getDatumRodjenja().toLocalDate());
        p.setBrojTelefona(pacijent.getBrojTelefona());
        p.setAdresa(pacijent.getAdresa());
        p.setRola(rolaRepozitorijum.findByNaziv("ROLE_PACIJENT").get(0));
        p.setPregledi(new ArrayList<>());

        String sifra = generisiSifru();
        String enkodovanaSifra = enkoderLozinke.encode(sifra);

        p.setLozinka(enkodovanaSifra);
        pacijentRepozitorijum.save(p);

        emailServis.posaljiLoginKredencijaleNaMejl(new PrijavaDTO(pacijent.getEmail(), sifra));
    }

    public static String generisiSifru() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[14];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public void sacuvaj(Pacijent pacijent) {
        this.pacijentRepozitorijum.save(pacijent);
    }
}
