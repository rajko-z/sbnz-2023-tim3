package com.ftn.sbnz2023tim3.model.modeli.enumeracije.kategorije;

public enum EpilepsijaKategorijaPitanja {
    SIMPTOMI_NAPADA(1.5),
    UCESTALOST_NAPADA(2.5),
    OKIDACI_NAPADA(1.1),
    FAKTORI_RIZIKA(2.0),
    DODATNI_SIMPTOMI(1.0);

    private final double value;

    EpilepsijaKategorijaPitanja(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return this.name();
    }
}
