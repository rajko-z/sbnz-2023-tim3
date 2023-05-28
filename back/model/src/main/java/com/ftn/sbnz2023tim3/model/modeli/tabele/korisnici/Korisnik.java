package com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.ftn.sbnz2023tim3.model.modeli.enumeracije.Uzrast;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Korisnik implements UserDetails {

    @Id
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String lozinka;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column
    private String brojTelefona;

    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(nullable = false)
    private LocalDateTime datumRodjenja;

    @Column
    private String adresa;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role rola;

    @Column
    private Date datumPoslednjePromeneSifre;

    public int getBrojGodina() {
        return (int) ChronoUnit.YEARS.between(datumRodjenja, LocalDateTime.now());
    }

    public Uzrast getUzrast() {
        long brojGodina = getBrojGodina();

        if (brojGodina <= 12) {
            return Uzrast.DETE;
        }
        if (brojGodina < 18) {
            return Uzrast.ADOLESCENT;
        }
        return Uzrast.ODRASTAO;
    }

    //=========================== FOR SECURITY ===========================//

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(this.rola);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.lozinka;
    }
}