package com.ftn.sbnz2023tim3.service.pomocneKlase;

import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Korisnik;
import com.ftn.sbnz2023tim3.model.modeli.tabele.korisnici.Role;
import com.ftn.sbnz2023tim3.service.konfiguracija.JWTKonfiguracija;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@AllArgsConstructor
public class TokenUtils {

    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
    private static final String AUDIENCE_WEB = "web";
    private static final String AUTH_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private final JWTKonfiguracija jwtConfig;

    public String generateToken(String username, Role role) {
        return Jwts.builder()
                .setIssuer(jwtConfig.appName())
                .setSubject(username)
                .claim("role", role)
                .setAudience(AUDIENCE_WEB)
                .setIssuedAt(new Date())
                .setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALGORITHM, jwtConfig.jwtSecret())
                .compact();
    }

    public String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader(AUTH_HEADER);

        if (authHeader != null && authHeader.startsWith(BEARER_PREFIX)) {
            return authHeader.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        Korisnik user = (Korisnik) userDetails;
        final String username = getUsernameFromToken(token);
        final Date created = getIssuedAtDateFromToken(token);

        boolean usernameValid = username != null && userDetails.getUsername().equals(username);
        boolean isCreatedAfterLastPasswordReset = user.getDatumPoslednjePromeneSifre() == null ||  (created != null && created.after(user.getDatumPoslednjePromeneSifre()));
        boolean isAlgorithmValid = SIGNATURE_ALGORITHM.getValue().equals(getAlgorithmFromToken(token));

        return usernameValid &&
               isCreatedAfterLastPasswordReset &&
               isAlgorithmValid;
    }

    private Date getIssuedAtDateFromToken(String token) {
        try {
            Claims claims =  Jwts.parser()
                    .setSigningKey(jwtConfig.jwtSecret())
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getIssuedAt();
        } catch (Exception e) {
            return null;
        }
    }

    private String getAlgorithmFromToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtConfig.jwtSecret())
                    .parseClaimsJws(token)
                    .getHeader()
                    .getAlgorithm();
        } catch (Exception e) {
            return null;
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            Claims claims =  Jwts.parser()
                    .setSigningKey(jwtConfig.jwtSecret())
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + jwtConfig.jwtExpiresIn());
    }
}
