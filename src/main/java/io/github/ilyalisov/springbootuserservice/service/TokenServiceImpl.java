package io.github.ilyalisov.springbootuserservice.service;

import io.github.ilyalisov.springbootuserservice.model.TokenParameters;
import io.github.ilyalisov.springbootuserservice.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    /**
     * JWT properties for token generation.
     */
    private final JwtProperties properties;

    /**
     * Secret key for token generation and validation.
     */
    private SecretKey key;

    @PostConstruct
    protected void init() {
        key = Keys.hmacShaKeyFor(properties.getSecret().getBytes());
    }

    @Override
    public String generate(
            final TokenParameters params
    ) {
        Claims claims = Jwts.claims()
                .subject(params.getSubject())
                .add(params.getFields())
                .build();
        return Jwts.builder()
                .claims(claims)
                .issuedAt(params.getIssuedAt())
                .expiration(params.getExpiredAt())
                .signWith(key)
                .compact();
    }

    @Override
    public boolean isValid(
            final String token
    ) {
        try {
            Jws<Claims> claims = Jwts
                    .parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return claims.getPayload()
                    .getExpiration()
                    .after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public HashMap<String, Object> fields(
            final String token
    ) {
        Jws<Claims> claims = Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
        return new HashMap<>(claims.getPayload());
    }

}
