package com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori;

public enum DaNeOdgovor {
    DA (2), NE(0);

    private final int value;

    DaNeOdgovor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name();
    }
}
