package com.ftn.sbnz2023tim3.model.models.dto;

import com.ftn.sbnz2023tim3.model.models.enums.SignalState;
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
public class SignalEntryResult {

    private LocalDateTime timestamp;

    private SignalState state;

    private SignalType signalType;

    private Examination examination;
}
