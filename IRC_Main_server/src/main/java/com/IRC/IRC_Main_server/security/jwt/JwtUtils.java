package com.IRC.IRC_Main_server.security.jwt;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.core.Authentication;

import com.IRC.IRC_Main_server.payload.response.SessionToken;
import com.IRC.IRC_Main_server.security.services.UserDetailsImpl;

import io.jsonwebtoken.*;

import org.springframework.stereotype.Component;


@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	
	@Value("${irc.app.RefreshjwtSecret}")
	private String RefreshjwtSecret;

	@Value("${irc.app.RefreshjwtExpirationMS}")
	private int RefreshjwtExpirationMS;
	
	@Value("${irc.app.jwtSecret}")
	private String jwtSecret;

	@Value("${irc.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public SessionToken generateJwtToken(String username) {
		
		return generatetoken(username, jwtSecret, jwtExpirationMs,"Bearer");
	}
	
	public SessionToken generateRefreshJwtToken(String username) {
		return generatetoken(username, RefreshjwtSecret, RefreshjwtExpirationMS,"Refresh");
	}
	private SessionToken generatetoken(String username,String secret,int refresh,String type) {
		
		String token= Jwts.builder()
			.setSubject(username)
			.setIssuedAt(new Date())
			.setExpiration(new Date((new Date()).getTime() + refresh))
			.signWith(SignatureAlgorithm.HS512, secret)
			.compact();
	
		return new SessionToken(token,type,refresh);
		
		
		
		
	}
	
	public String getUserNameFromRefreshJwtToken(String token) {
		return getUserNameFromToken(token, RefreshjwtSecret);
	}
	
	public String getUserNameFromJwtToken(String token) {
		return getUserNameFromToken(token, jwtSecret);
	}
	private String getUserNameFromToken(String token,String secret) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	public boolean validateRefreshJwtToken(String authToken) {
		return validateToken(authToken,RefreshjwtSecret);
	}
	public boolean validateJwtToken(String authToken) {
		return validateToken(authToken, jwtSecret);
	}
	private boolean validateToken(String authToken,String secret) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
	
}
