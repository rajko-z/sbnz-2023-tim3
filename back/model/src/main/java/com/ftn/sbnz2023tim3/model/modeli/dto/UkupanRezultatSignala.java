package com.ftn.sbnz2023tim3.model.modeli.dto;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class UkupanRezultatSignala {
    private LocalDateTime timestamp;

    private int brojSignala;

    private float procenatNormalnih;

    private float procenatNiskih;

    private float procenatVisokih;

    private TipSignala tipSignala;

    private Pregled pregled;
}
