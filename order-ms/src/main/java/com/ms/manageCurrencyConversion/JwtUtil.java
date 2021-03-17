package com.ms.manageCurrencyConversion;

import java.util.Random;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private String SECRET_KEY = "secret";
	
	public String generateToken(String userName) {
		Random rand = new Random();
		 double rand_dub1 = rand.nextDouble(); 
        Claims claims = Jwts.claims().setSubject(userName+rand_dub1);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
