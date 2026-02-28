package com.SpringStudy.SpringProject.week3.day24.morning.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

public class JwtService {

    private final String SECRET_KEY = "my_secret_key";

    public String generateToken(String userName) {
        return
                Jwts.builder()
                        .setSubject(userName)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) //1 hr
                        .signWith(
                                Keys.hmacShaKeyFor(SECRET_KEY.getBytes()),
                                SignatureAlgorithm.HS256
                        )
                        .compact();

    }

    public String extractUsername(String token) {
        return
                Jwts.parserBuilder()
                        .setSigningKey(SECRET_KEY.getBytes())
                        .build()
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
    }

}
