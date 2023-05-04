package com.ftn.sbnz2023tim3.service.izuzeci;

public class ForbiddenAccessException extends AplikacijaIzuzetak {

    public ForbiddenAccessException(String message) {
        super(message);
    }

    public ForbiddenAccessException() { super();}
}
