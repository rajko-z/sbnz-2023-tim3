package com.ftn.sbnz2023tim3.service.kontroleri;

import com.ftn.sbnz2023tim3.model.modeli.dto.GenerisanSignal;
import com.ftn.sbnz2023tim3.service.servisi.SignalServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/signali")
public class SignalKontroler {

    private final SignalServis signalServis;

    @PostMapping("/preuzmi-signal")
    public ResponseEntity<?> preuzmiSignal(@RequestBody GenerisanSignal generisanSignal) {
        signalServis.preuzmiSignal(generisanSignal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
