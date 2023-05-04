package com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="role")
@Getter
@Setter
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return naziv;
    }
}
