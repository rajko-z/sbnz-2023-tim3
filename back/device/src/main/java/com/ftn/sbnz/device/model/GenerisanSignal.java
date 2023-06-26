package com.ftn.sbnz.device.model;

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
