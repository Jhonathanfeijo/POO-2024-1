package com.sosmt.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sosmt.infra.TokenService;
import com.sosmt.mapper.UsuarioMapper;
import com.sosmt.model.usuario.Usuario;
import com.sosmt.model.usuario.dto.UsuarioLoginRequest;
import com.sosmt.model.usuario.dto.UsuarioRegisterRequest;
import com.sosmt.service.usuario.UsuarioService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/auth/register")
	@Transactional
	public ResponseEntity criarUsuario(@RequestBody UsuarioRegisterRequest request, UriComponentsBuilder builder) {
		Usuario usuario = usuarioService.criarUsuario(UsuarioMapper.INSTANCE.usuarioRegisterRequestToUsuario(request));
		var token = tokenService.criarToken(usuario);
		URI uri = builder.path("/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
		return ResponseEntity.created(uri).body(token);
	}

	@PostMapping("/auth/login")
	public ResponseEntity logar(@RequestBody UsuarioLoginRequest request) {
		Usuario usuario = UsuarioMapper.INSTANCE.usuarioLoginRequestToUsuario(request);
		var usernamePasswordToken = new UsernamePasswordAuthenticationToken(usuario, usuario.getSenha());
		var auth = manager.authenticate(usernamePasswordToken);
		String token = tokenService.criarToken((Usuario) auth.getPrincipal());
		return ResponseEntity.ok(token);
	}

}
