package com.ftn.sbnz2023tim3.service.konfiguracija;

import com.ftn.sbnz2023tim3.service.pomocneKlase.TokenUtils;
import com.ftn.sbnz2023tim3.service.servisi.korisnici.KorisnikServis;
import com.ftn.sbnz2023tim3.service.servisi.sigurnost.RestAuthenticationEntryPoint;
import com.ftn.sbnz2023tim3.service.servisi.sigurnost.TokenAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class WebSecurityKonfiguracija extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder enkoderSifre;

    private final KorisnikServis korisnikServis;

    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    private final TokenUtils tokenUtils;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(korisnikServis).passwordEncoder(enkoderSifre);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

            .authorizeRequests()
            .antMatchers("/ws/**").permitAll()
            .anyRequest().authenticated().and()
            .cors().and()
            .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, korisnikServis), BasicAuthenticationFilter.class);

        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.POST,
                "/**/auth/login", "/**/signali/preuzmi-signal");

        web.ignoring().antMatchers(HttpMethod.GET,
                "/", "/webjars/**",
                "/*.html",
                "favicon.ico",
                "/**/*.html",
                "**/ws",
                "**/ws/**",
                "/**/*.css",
                "/**/*.js",
                "/socket/**"
                );
    }
}
