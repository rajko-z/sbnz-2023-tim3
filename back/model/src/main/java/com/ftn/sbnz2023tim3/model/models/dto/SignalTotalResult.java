package com.ftn.sbnz2023tim3.model.models.dto;

import com.ftn.sbnz2023tim3.model.models.enums.SignalType;
import com.ftn.sbnz2023tim3.model.models.tables.Examination;
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
public class SignalTotalResult {
    private LocalDateTime timestamp;

    private int totalCounter;

    private float normalPercentage;

    private float lowerPercentage;

    private float higherPercentage;

    private SignalType signalType;

    private Examination examination;
}
