package com.sns.example.server.service.impl;

import com.sns.example.server.client.SecurityClient;
import com.sns.example.server.dto.AuthRequest;
import com.sns.example.server.dto.JwtResponse;
import com.sns.example.server.dto.RefreshJwtRequest;
import com.sns.example.server.model.JwtAuthentication;
import com.sns.example.server.service.AuthService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Slf4j
@Component
public final class AuthServiceImpl implements AuthService {

    private final SecurityClient client;
    private final SecretKey jwtSecret;

    public AuthServiceImpl(@Value("${jwt.secret}") String secret, SecurityClient client) {
        this.jwtSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        this.client = client;
    }

    @Override
    public String login(AuthRequest request) {
        JwtResponse response = client.login(request);
        validateToken(response.getAccessToken());

        return response.getAccessToken();
    }

    @Override
    public JwtResponse getNewAccessToken(RefreshJwtRequest request) {
        return client.getNewAccessToken(request);
    }

    @Override
    public JwtResponse getNewRefreshToken(RefreshJwtRequest request) {
        return client.getNewRefreshToken(request);
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtSecret)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired", expEx);
        } catch (UnsupportedJwtException unsEx) {
            log.error("Unsupported jwt", unsEx);
        } catch (MalformedJwtException mjEx) {
            log.error("Malformed jwt", mjEx);
        } catch (SignatureException sEx) {
            log.error("Invalid signature", sEx);
        } catch (Exception e) {
            log.error("invalid token", e);
        }
        return false;
    }

    @Override
    public Claims getClaims(@NonNull String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public JwtAuthentication getAuthentication() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

}