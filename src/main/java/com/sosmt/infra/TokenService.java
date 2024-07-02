package com.sosmt.infra; 

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sosmt.model.usuario.Usuario;

@Service
public class TokenService {
	
	@Value("${secret-jwt")
	private String secret;

	public String criarToken(Usuario usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.create().withIssuer("sos-mt").withSubject(usuario.getEmail())
					.withClaim("id", usuario.getIdUsuario())
					.withClaim("email", usuario.getEmail())
					.withClaim("nome", usuario.getNomeUsuario()).withClaim("cpf", usuario.getCpf()).sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Não foi possível gerar o token");

		}
	}

	public String validarToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("sos-mt").build().verify(token).getSubject();
		} catch (JWTVerificationException exception) {
			throw new RuntimeException("Token inválido");
		}
	}

}
