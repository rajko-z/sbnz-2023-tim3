package com.ftn.sbnz2023tim3.model.models.tables.users;

import com.ftn.sbnz2023tim3.model.models.tables.Examination;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="doctors")
@Getter
@Setter
public class Doctor extends User {

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Examination> examinations = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Examination currentExamination;
}
