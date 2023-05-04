package com.ftn.sbnz2023tim3.service.izuzeci;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorMessage{

    private int statusCode;

    private Date timestamp;

    private String poruka;

}
