package com.dwteam.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
@Component
public class Token {
    public String CreateToken_HS256(String userName,Long id) throws UnsupportedEncodingException {
        String jwt = null;
             jwt= Jwts.builder().setIssuer("Mohammad").setSubject("").claim("userName",userName).claim("id",id).setSubject("Login").signWith(
                    SignatureAlgorithm.HS256,
                    ConfigToken.secretToken.getBytes("UTF-8")
            ).compact();
        return jwt;
    }

}
