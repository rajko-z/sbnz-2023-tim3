package com.ftn.sbnz2023tim3.model.modeli.enumeracije.kategorije;


public enum AlchajmerKategorijaPitanja {
    KOGNITIVNA(2.0),
    SVAKODNEVNICA(1.0),
    SOCIJALNO_EMITVNO(1.5);

    private final double value;


    AlchajmerKategorijaPitanja(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return this.name();
    }
}
