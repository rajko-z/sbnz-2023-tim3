package com.ftn.sbnz2023tim3.model.modeli.dto;

import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;
import lombok.*;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class RezultatSignala {

    private Date timestamp;
    private Long pregledId;
    private TipSignala tip;
    private double brojPovisenih;
    private double brojSmanjenih;
    private double brojNormalnih;
    private double ukupanBroj;
}
