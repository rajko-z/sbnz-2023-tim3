package com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici;

import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="doktori")
@Getter
@Setter
public class Doktor extends Korisnik {

    @OneToMany(mappedBy = "doktor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pregled> pregledi = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Pregled trenutniPregled;
}
