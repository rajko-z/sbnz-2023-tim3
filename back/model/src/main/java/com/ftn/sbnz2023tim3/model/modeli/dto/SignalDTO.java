package com.ftn.sbnz2023tim3.model.modeli.dto;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.DeoMozga;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjePacijenta;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignalDTO {
    private int donjaFrekvencija;
    private int gornjaFrekvencija;
    private int donjaAmplituda;
    private int gornjaAmplituda;
    private List<DeoMozga> predeliMozga;
    private StanjePacijenta stanjePacijenta;
    private TipSignala tipSignala;
}
