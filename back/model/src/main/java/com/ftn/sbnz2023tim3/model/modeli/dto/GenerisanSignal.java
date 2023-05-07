package com.ftn.sbnz2023tim3.model.modeli.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenerisanSignal {

    private Signal alfaSignal;
    private Signal betaSignal;
    private Signal gamaSignal;
    private Signal deltaSignal;
    private Signal tetaSignal;
}
