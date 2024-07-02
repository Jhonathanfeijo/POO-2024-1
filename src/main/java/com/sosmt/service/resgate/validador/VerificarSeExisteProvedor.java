package com.sosmt.service.resgate.validador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sosmt.modal.resgate.dto.ResgateRequest;
import com.sosmt.repositories.ProvedorAjudaRepository;

@Component
public class VerificarSeExisteProvedor implements ValidadorResgate {

	@Autowired
	private ProvedorAjudaRepository provedorRepository;
	
	@Override
	public void validar(ResgateRequest resgate) {
		if(!provedorRepository.existsById(resgate.getIdProvedor()))
			throw new RuntimeException("Provedor de ajuda não encontrado");
		
	}

}
