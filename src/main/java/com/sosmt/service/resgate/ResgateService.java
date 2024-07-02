package com.sosmt.service.resgate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sosmt.modal.resgate.dto.ResgateRequest;
import com.sosmt.model.Resgate.Resgate;
import com.sosmt.model.provedorAjuda.ProvedorAjuda;
import com.sosmt.model.usuario.Usuario;
import com.sosmt.repositories.ProvedorAjudaRepository;
import com.sosmt.repositories.ResgateRepository;
import com.sosmt.repositories.UsuarioRepository;
import com.sosmt.service.resgate.validador.ValidadorResgate;

@Service
public class ResgateService {

	@Autowired
	private List<ValidadorResgate> validadores;

	@Autowired
	private ResgateRepository resgateRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProvedorAjudaRepository provedorRepository;

	public Resgate registrarResgate(ResgateRequest request) {
		validadores.forEach((v) -> v.validar(request));

		Usuario usuario = usuarioRepository.findById(request.getIdUsuario()).get();
		ProvedorAjuda provedorAJuda = provedorRepository.findById(request.getIdProvedor()).get();

		Resgate resgate = new Resgate(usuario, provedorAJuda, request.getEndereco(), request.getDescricao());
		resgate = resgateRepository.save(resgate);

		return resgate;
	}

	public Resgate obterResgatePorId(String idResgate) {
		return resgateRepository.findById(idResgate).orElseThrow(() -> new RuntimeException("Resgate não encontrado"));
	}

	public List<Resgate> obterResgatesPorUsuarioId(String idUsuario) {

		return resgateRepository.findAllByUsuarioIdUsuario(idUsuario);
	}

	public List<Resgate> obterTodosResgates() {
		return resgateRepository.findAll();
	}
}
