package com.sosmt.service.usuario.validadacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sosmt.model.usuario.Usuario;
import com.sosmt.repositories.UsuarioRepository;

@Component
public class ValidadorExisteCpfCadastrado implements ValidadorUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void validar(Usuario usuario) {

		boolean existeCpfCadastrado = usuarioRepository.existsByCpf(usuario.getCpf());
		if (existeCpfCadastrado)
			throw new RuntimeException("Já existe CPF cadastrado");

	}

}
