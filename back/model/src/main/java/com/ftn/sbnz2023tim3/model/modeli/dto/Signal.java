package com.ftn.sbnz2023tim3.model.modeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.DeoMozga;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjePacijenta;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.TipSignala;
import com.ftn.sbnz2023tim3.model.modeli.tabele.Pregled;
import lombok.*;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import javax.persistence.Transient;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class Signal {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime timestamp;

    private int frekvencija;

    private int amplituda;

    private DeoMozga deoMozga;

    private StanjePacijenta stanjePacijenta;

    private TipSignala tip;

    @Transient
    private Pregled pregled;
}
