package com.ftn.sbnz2023tim3.service.izuzeci;

public class BadRequestException extends AplikacijaIzuzetak {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException() { super();}
}
