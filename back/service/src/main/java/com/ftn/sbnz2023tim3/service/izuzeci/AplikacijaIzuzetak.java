package com.ftn.sbnz2023tim3.service.izuzeci;

public class AplikacijaIzuzetak extends RuntimeException {

    private String poruka;

    public AplikacijaIzuzetak() {
        super();
    }

    public AplikacijaIzuzetak(String poruka) {
        super();
        this.poruka = poruka;
    }

    @Override
    public String getMessage() {
        return this.poruka;
    }
}
