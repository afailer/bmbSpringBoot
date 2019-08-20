package com.tjwq.bmb.utils;

import com.tjwq.bmb.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    public static final String SUBJECT = "bmb";

    public static final long EXPIRE = 1000*60*60*24*7; //1周的过期时间

    public static final String APPSECRET = "bmb666";

    public static String geneJsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", user.getId())
                .claim("name",user.getUser_name())
                .claim("img",user.getImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();
        return token;
    }

    public static Claims checkJWT(String token){

        try{
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET)
                    .parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }
}
