package com.dwteam.jwt;

import com.dwteam.exceptions.ForbiddenExp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
@Component
public class Token {
    public String CreateToken_HS256_Person(String userName, Long id, String secret) throws UnsupportedEncodingException {
        String jwt = null;
             jwt= Jwts.builder().setIssuer("Mohammad").claim("id",id).setSubject(userName).signWith(
                    SignatureAlgorithm.HS256,
                    secret.getBytes("UTF-8")
            ).compact();
        return jwt;
    }
    public boolean validateToken(String token) {
        try {
            System.out.println(token);
            Jwts.parser().setSigningKey(ConfigToken.secretToken).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new ForbiddenExp("You do not have access",this.getClass().getName());
        }
    }
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(ConfigToken.secretToken).parseClaimsJws(token).getBody();
    }

}
