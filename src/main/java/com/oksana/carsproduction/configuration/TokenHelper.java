package com.oksana.carsproduction.configuration;

import com.oksana.carsproduction.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class TokenHelper {

    private static final String ISSUER = "com.oksana";
    private static final byte[] SECRET_KEY = "superSecretKey".getBytes();

    public String getUsernameFromToken(String token) {
        try {
            return this.getClaimsFromToken(token).getSubject();
        }
        catch (Exception e) {
            return null;
        }
    }

    public Boolean verifyToken(String token, User user) {
        final String username = this.getUsernameFromToken(token);
        if (username == null) return false;

        // TODO: add expiration verification
        return username.equals(user.getUsername());
    }

    public String tokenFor(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        // TODO: For now the token do
        //  es not expire, but down the road we should restrict its lifetime
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuer(ISSUER)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    private Claims getClaimsFromToken(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

}
