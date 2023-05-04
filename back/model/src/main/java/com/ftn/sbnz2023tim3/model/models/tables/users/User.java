package com.ftn.sbnz2023tim3.model.models.tables.users;

import com.ftn.sbnz2023tim3.model.models.enums.Age;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User implements UserDetails {

    @Id
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private int age;

    @Column
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    public Age getAgeType() {
        if (age <= 12) {
            return Age.CHILD;
        }
        if (age < 18) {
            return Age.ADOLESCENT;
        }
        return Age.ADULT;
    }

    //=========================== FOR SECURITY ===========================//

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(this.role);
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
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}