package com.ftn.sbnz2023tim3.model.modeli.dto.pregled;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ftn.sbnz2023tim3.model.modeli.dto.KorisnikDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.lekovi.IzdatLekDTO;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.adhd.PopunjenAdhdUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.alchajmer.PopunjenAlchajmerUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.epilepsija.PopunjenEpilepsijaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.dto.upitnici.nesanica.PopunjenNesanicaUpitnik;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.StanjeEEGPregleda;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PregledDTO {

    private Long id;
    private KorisnikDTO doktor;
    private KorisnikDTO pacijent;
    private List<IzdatLekDTO> izdatiLekovi;
    private double adhdProcenat;
    private double alchajmerProcenat;
    private double nesanicaProcenat;
    private double epilepsijaProcenat;
    private String beleske;
    private String zakljucak;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime eegVremePocetka;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime eegVremeZavrsetka;
    private boolean zavrsen;
    private PopunjenAdhdUpitnik adhdUpitnik;
    private PopunjenAlchajmerUpitnik alchajmerUpitnik;
    private PopunjenEpilepsijaUpitnik epilepsijaUpitnik;
    private PopunjenNesanicaUpitnik nesanicaUpitnik;
    private StanjeEEGPregleda stanjeEEGPregleda;
}
