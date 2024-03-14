package com.snsclicksystem.main.auth.jwt;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider implements InitializingBean{

	private Key key;
	
	private static final String AUTORITIES_KEY = "auth";
	
	private final String secret;
	private final long tokenValidityInMilliseconds;
	
	
	public JwtTokenProvider(@Value("${jwt.secret}") String secret,
			@Value("${jwt.token-validity-in-seconds}") long tokenValidityInSeconds) {
		this.secret = secret;
		this.tokenValidityInMilliseconds = tokenValidityInSeconds * 1000;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		byte[] keyBytes = Decoders.BASE64.decode(secret);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}
	
	public String createToken(Authentication authentication) {
		// 권한 가져오기
        String authorities = this.convertToString(authentication);
        
        return Jwts.builder()
                .setSubject(authentication.getName()) 
                .claim(AUTORITIES_KEY, authorities) // 권한 정보
                .setExpiration(getExpireTime()) // 만료 시간
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
	}
	
	/**
     * 토큰 정보 검증
     *
     * @param token
     * @return
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
        }
        return false;
    }
    
    /**
     * token 정보 복호화
     *
     * @param accessToken
     * @return
     */
    public Authentication getAuthentication(String accessToken) {
        // 토큰 복호화
        Claims claims = parseClaims(accessToken);

        // 복호화한 Claim 에 권한 정보가 없으면 예외 발생
        
        if (claims.get(AUTORITIES_KEY) == null) {
        	// TODO : Exception Customizing
        	//throw new CustomException(PERMISSION_NOT_ACCESSIBLE);
        	throw new RuntimeException();
        }
        	
        // 복호화한 Claim 에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities = convertToAuthorities(claims.get(AUTORITIES_KEY).toString());

        // UserDetails 객체를 만들어 Authentication 리턴
        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, accessToken, authorities);
    }    
	
    /**
     * 만료 시간 계산
     *
     * @param 
     * @return
     */
	private Date getExpireTime() {
		return new Date(new Date().getTime() + this.tokenValidityInMilliseconds);
	}
	
    /**
     * Authentication 객체에서 authorities 가져와 토큰에 담을 수 있게 문자열로 변환
     *
     * @param authentication
     * @return
     */
    private String convertToString(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }
    
    /**
     * 토큰을 복호화 하여 토큰정보(claims)를 리턴
     *
     * @param accessToken
     * @return Claims
     */
    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
    
    /**
     * 문자열로 변환되어 있던 authorities 정보를 Collection 으로 변환
     *
     * @param data
     * @return
     */
    private Collection<? extends GrantedAuthority> convertToAuthorities(String data) {
        return Arrays.stream(data.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
