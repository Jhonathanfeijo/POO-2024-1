package com.sosmt.service.usuario.validadacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sosmt.model.usuario.Usuario;
import com.sosmt.repositories.UsuarioRepository;

@Component
public class ValidadorJaExisteEmailCadastrado implements ValidadorUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void validar(Usuario usuario) {

		boolean existeEmailCadastrado = usuarioRepository.existsByEmail(usuario.getEmail());
		if (existeEmailCadastrado)
			throw new RuntimeException("Existe email cadastrado");

	}

}
