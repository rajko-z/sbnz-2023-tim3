package com.ftn.sbnz2023tim3.model.modeli.enumeracije.odgovori;

public enum TrajanjeOdgovor {
    KRATKO(1), SREDNJE(2), DUGO(3);


    private final int value;

    TrajanjeOdgovor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name();
    }
}
