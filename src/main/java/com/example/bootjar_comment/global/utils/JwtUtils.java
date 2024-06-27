package com.example.bootjar_comment.global.utils;

import com.example.bootjar_comment.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtils {
    private final SecretKey secretKey;

    public User parseToken(String token) {
        Claims payload = (Claims) Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parse(token)
                .getPayload();

        Long userId = payload.get("id", Long.class);
        String userNickname = payload.get("nickname", String.class);
        String userImage = payload.get("image", String.class);

        return new User(userId, userNickname, userImage);
    }

    public JwtUtils(@Value("${token.secret}") String secret) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }
}
