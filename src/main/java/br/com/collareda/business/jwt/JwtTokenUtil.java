package br.com.collareda.business.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;

//retorna o username do token jwt 
	public String getUsernameFromToken(String token) {
		token = token.replace("Bearer ", "");
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public Long getPartnerID(String token) {
		token = token.replace("Bearer ", "");
		Claims claims = getAllClaimsFromToken(token);
		return Long.valueOf((Integer) claims.get("partnerId"));
	}
	
	public Long getUserID(String token) {
		token = token.replace("Bearer ", "");
		Claims claims = getAllClaimsFromToken(token);
		return Long.valueOf((Integer) claims.get("userId"));
	}

//retorna expiration date do token jwt 
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);

	}

//para retornar qualquer informação do token nos iremos precisar da secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

//gera token para user
	public String generateToken(JwtUser jwtUser) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", jwtUser.getUserId());
		claims.put("partnerId", new Long(jwtUser.getPartnerId()));
		return doGenerateToken(claims, jwtUser.getUsername());
	}

//Cria o token e define tempo de expiração pra ele
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

//valida o token
	public Boolean validateToken(String token, JwtUser jwtUser) {
		final String username = getUsernameFromToken(token);
		return (username.equals(jwtUser.getUsername()) && !isTokenExpired(token));
	}

}