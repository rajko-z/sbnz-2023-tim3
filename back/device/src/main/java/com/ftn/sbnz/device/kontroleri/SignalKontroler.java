package com.ftn.sbnz.device.kontroleri;

import com.ftn.sbnz.device.model.dto.InfoZaGenerisanSignal;
import com.ftn.sbnz.device.model.dto.TextResponse;
import com.ftn.sbnz.device.zakazivaci.SignalScheduler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/signali")
public class SignalKontroler {
    private final SignalScheduler scheduler;

    @PostMapping("/pocetak")
    public ResponseEntity<?> zapocniGenerisanjeSignala(@RequestBody InfoZaGenerisanSignal infoZaGenerisanSignalDTO) {
        try {
            scheduler.startScheduler(infoZaGenerisanSignalDTO);
            return new ResponseEntity<>(new TextResponse("Scheduler started."), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new TextResponse("Something is wrong."), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/kraj")
    public ResponseEntity<?> stopScheduler() {
        try {
            scheduler.stopScheduler();
            return new ResponseEntity<>(new TextResponse("Scheduler stopped."), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new TextResponse("Something is wrong."), HttpStatus.BAD_REQUEST);
        }
    }
}
