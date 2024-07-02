package com.sosmt.service.denuncia.validador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sosmt.model.denuncia.dto.DenunciaRequest;
import com.sosmt.repositories.UsuarioRepository;

@Component
public class VerificadorExisteUsuario implements ValidadorDenuncia {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void validar(DenunciaRequest request) {
		if (!usuarioRepository.existsById(request.getIdUsuario()))
			throw new RuntimeException("Usuário não encontrado!");
	}

}
