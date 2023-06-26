package com.ftn.sbnz2023tim3.model.modeli.dto;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.DeoMozga;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjePacijenta;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;
import lombok.*;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class Signal {

    private Date timestamp;

    private int frekvencija;

    private int amplituda;

    private DeoMozga deoMozga;

    private StanjePacijenta stanjePacijenta;

    private TipSignala tip;

    private Long pregled;
}
