package com.gerenciamentodeprocessos.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.gerenciamentodeprocessos.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLastName())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
    throw new RuntimeException("Error while geneating token", exception);
        }
    }

    public  String validateToken(String token){

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
            return token;

        }catch (JWTCreationException exception){
            return "";
        }
    }

    private Instant getExpirationDate(){
        return LocalDateTime.now()
                .plusDays(1)
                .atZone(ZoneId.of("America/Sao_Paulo"))
                .toInstant();
    }
}
