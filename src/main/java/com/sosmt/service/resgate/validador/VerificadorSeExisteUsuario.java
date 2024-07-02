package com.sosmt.service.resgate.validador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sosmt.modal.resgate.dto.ResgateRequest;
import com.sosmt.repositories.UsuarioRepository;

@Component
public class VerificadorSeExisteUsuario implements ValidadorResgate {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void validar(ResgateRequest resgate) {
		if (!usuarioRepository.existsById(resgate.getIdUsuario()))
			throw new RuntimeException("Usuário não encontrado!");
	}

}
