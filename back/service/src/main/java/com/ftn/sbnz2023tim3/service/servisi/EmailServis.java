package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.dto.PrijavaDTO;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class EmailServis {

    private final JavaMailSender javaMailSender;

    private final Environment env;

    @Async
    public void posaljiLoginKredencijaleNaMejl(PrijavaDTO kredencijali) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(kredencijali.getEmail());
        message.setFrom(Objects.requireNonNull(env.getProperty("spring.mail.username")));
        message.setSubject("Vas nalog za sbnz2023tim3 je kreiran");
        message.setText("Korisnicko ime: " + kredencijali.getEmail() + "\nLozinka: " + kredencijali.getLozinka());
        javaMailSender.send(message);
    }
}
