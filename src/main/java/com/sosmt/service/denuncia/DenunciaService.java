package com.sosmt.service.denuncia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sosmt.model.denuncia.Denuncia;
import com.sosmt.model.denuncia.dto.DenunciaRequest;
import com.sosmt.model.usuario.Usuario;
import com.sosmt.repositories.DenunciaRepository;
import com.sosmt.repositories.UsuarioRepository;
import com.sosmt.service.denuncia.validador.ValidadorDenuncia;

@Service
public class DenunciaService {

	@Autowired
	private List<ValidadorDenuncia> validadores;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DenunciaRepository denunciaRepository;

	public Denuncia registrarDenuncia(DenunciaRequest request) {
		validadores.forEach((v) -> v.validar(request));
		System.out.println("aq");
		Usuario usuario = usuarioRepository.findById(request.getIdUsuario()).get();
		Denuncia denuncia = new Denuncia(request, usuario);
		return denunciaRepository.save(denuncia);
	}

	public Denuncia obterDenunciaPorId(String idDenuncia) {
		return denunciaRepository.findById(idDenuncia)
				.orElseThrow(() -> new RuntimeException("Denuncia não foi encontrada"));
	}

	public List<Denuncia> obterTodasDenuncias() {
		return denunciaRepository.findAll();
	}
	
	public List<Denuncia> obterDenunciasPorUsuarioId(String idUsuario){
		return denunciaRepository.findAllByUsuarioIdUsuario(idUsuario);
	}

}
