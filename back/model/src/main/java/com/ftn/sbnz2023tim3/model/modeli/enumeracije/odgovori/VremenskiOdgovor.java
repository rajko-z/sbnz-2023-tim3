package com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori;

public enum VremenskiOdgovor {
    NIKAD(0),
    RETKO(1),
    PONEKAD(2),
    CESTO(3);

    private final int value;

    VremenskiOdgovor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name();
    }
}
