package com.ftn.sbnz.device.izuzeci;

public class BadRequestException extends AplikacijaIzuzetak {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException() { super();}
}
