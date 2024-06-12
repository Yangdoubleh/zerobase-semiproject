package com.zerobase.semiproject.utils;

import com.zerobase.semiproject.dto.JwtDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private enum JwtType{
        AUTH(JWT_AUTH_EXPIRE_TIMEMS),
        REFRESH(JWT_REFRESH_EXPIRE_TIMEMS);

        private int expireTime;

        JwtType(int expireTime) {
            this.expireTime = expireTime;
        }

        public int getExpireTime() {
            return expireTime;
        }
    }

    private static String jwtPrivateKey;
    private static final int JWT_AUTH_EXPIRE_TIMEMS = 30 * 60 * 1000; // 1 hour
    private static final int JWT_REFRESH_EXPIRE_TIMEMS = 14 * 24 * 60 * 60 * 1000; //14 day
    private static final SignatureAlgorithm JWT_ALGORITHM = SignatureAlgorithm.HS256;

    @Value("${jwt.privateKey}")
    public void jwtInit(String jwtPrivateKey) {
        this.jwtPrivateKey = jwtPrivateKey;
    }

    public static JwtDto createJwtToken(Long userKey) {
        Claims claims = Jwts.claims();
        claims.put("userKey", userKey);

        String authToken = createJwt(claims, JwtType.AUTH);
        String refreshToken = createJwt(claims, JwtType.REFRESH);

        return JwtDto.builder()
                               .authToken(authToken)
                               .refreshToken(refreshToken)
                               .build();
    }

    public static boolean isExpired(String token) {
        return Jwts.parser().setSigningKey(jwtPrivateKey).parseClaimsJwt(token)
                .getBody().getExpiration().before(new Date());
    }

    private static String createJwt (Claims claims, JwtType jwtType) {
        return Jwts.builder()
                            .setClaims(claims)
                            .setIssuedAt(new Date(System.currentTimeMillis()))
                            .setExpiration(new Date(System.currentTimeMillis() + jwtType.getExpireTime()))
                            .signWith(JWT_ALGORITHM, jwtPrivateKey)
                            .compact();
    }

    public static Long getUserKey(String token) {
        return Jwts.parser().setSigningKey(jwtPrivateKey).parseClaimsJws(token)
                .getBody().get("userKey", Long.class);
    }
}
