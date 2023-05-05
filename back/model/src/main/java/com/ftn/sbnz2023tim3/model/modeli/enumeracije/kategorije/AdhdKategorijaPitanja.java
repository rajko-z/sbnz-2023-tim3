package com.ftn.sbnz2023tim3.model.modeli.enumeracije.kategorije;

public enum AdhdKategorijaPitanja {
    NEPAZNJA(1.0),
    HIPERAKTIVNOST(1.2),
    IMPULSIVNOST(1.3);

    private final double value;


    AdhdKategorijaPitanja(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return this.name();
    }
}
