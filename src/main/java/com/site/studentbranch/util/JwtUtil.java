package com.site.studentbranch.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtUtil {
    public static String SECRET_KEY = "$@Hello These is the Secret key for the token utiliziation";
    public SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    public String generateToke(String username) {
        return Jwts.builder()
                .subject(username)
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .issuedAt(new Date())
                .signWith(key)
                .compact();
    }

    public boolean valideToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String userName(String token) {
        return getClaims(token).getSubject();
    }
}
