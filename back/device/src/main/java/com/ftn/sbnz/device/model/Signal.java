package com.ftn.sbnz.device.model;

import com.ftn.sbnz.device.model.enumeracije.DeoMozga;
import com.ftn.sbnz.device.model.enumeracije.StanjePacijenta;
import com.ftn.sbnz.device.model.enumeracije.TipSignala;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Signal {

    private Date timestamp;

    private int frekvencija;

    private int amplituda;

    private DeoMozga deoMozga;

    private StanjePacijenta stanjePacijenta;

    private TipSignala tip;

    private Long pregled;
}
