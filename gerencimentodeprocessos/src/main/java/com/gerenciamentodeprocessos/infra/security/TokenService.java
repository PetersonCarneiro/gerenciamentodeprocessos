package com.gerenciamentodeprocessos.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gerenciamentodeprocessos.domain.user.User;
import com.gerenciamentodeprocessos.domain.user.UserType;
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
            String role = user.getUserType().toString();

            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLogin())
                    .withClaim("role",role)
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
    throw new RuntimeException("Error while generating token", exception);
        }
    }

    public  String validateToken(String token){

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTCreationException exception){
            throw new RuntimeException("Token", exception);
        }
    }

    private Instant getExpirationDate(){
        return LocalDateTime.now()
                .plusDays(1)
                .atZone(ZoneId.of("America/Sao_Paulo"))
                .toInstant();
    }

    public DecodedJWT decodeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
                .withIssuer("auth-api")
                .build()
                .verify(token);
    }

}
