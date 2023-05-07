package com.ftn.sbnz2023tim3.model.modeli.dto.lekovi;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class IzdatLekDTO {
    private OpisLekaDTO opisLeka;
    private String opisDoze;
}
