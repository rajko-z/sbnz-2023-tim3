package com.ftn.sbnz2023tim3.model.modeli.dto;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.DeoMozga;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjePacijenta;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class Signal {

    private LocalDateTime timestamp;

    private int frekvencija;

    private int amplituda;

    private DeoMozga deoMozga;

    private StanjePacijenta stanjePacijenta;

    private TipSignala tip;

    private Pregled pregled;
}
