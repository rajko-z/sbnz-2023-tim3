package com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori;

public enum UcestalostOdgovor {
    NIKAD(0),
    PET_GODINA(1),
    GODINA(2),
    MESEC(3),
    NEDELJA(4);

    private final int value;

    UcestalostOdgovor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name();
    }
}
