package br.com.collareda.business.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtUser {
	private String username;
	private String password;
	private Long partnerId;
	private Long userId;
}
