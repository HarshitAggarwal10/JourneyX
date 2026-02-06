package com.apc.user.security;

import io.jsonwebtoken.Jwts;

import java.nio.charset.StandardCharsets;

public class JwtValidator {

    private static final String SECRET_KEY = "12345678901234567890123456789012";

    public static String extractUsername(String token) {

        try {
            return Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}
