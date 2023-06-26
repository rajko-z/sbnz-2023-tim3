package com.ftn.sbnz2023tim3.model.modeli.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenerisanSignal {

    private List<Signal> signals;
}
