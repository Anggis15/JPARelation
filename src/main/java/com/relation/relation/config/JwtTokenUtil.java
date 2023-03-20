package com.relation.relation.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
//    8535593094115651238
    private static final long serialVersionUID = 8535593094115651238L;
    
    private static final long JWT_TOKEN_VALIDITY = 5*60*60;
    @Value("${jwt.secret}")
    private String secret;

    //menerima username JWT token
    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }
    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsForToken(token);
        return claimsResolver.apply(claims);
    }
    //	Menerima name dari token
    public String getNameFromToken(String token) {
        return getAllClaimsForToken(token).get("name").toString();
    }
    private Claims getAllClaimsForToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<String, Object>();
        String token = Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }
    public boolean validateToken(String token, UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
