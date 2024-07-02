package com.sosmt.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sosmt.modal.resgate.dto.ResgateResponseDto;
import com.sosmt.model.denuncia.Denuncia;
import com.sosmt.model.denuncia.dto.DenunciaRequest;
import com.sosmt.model.denuncia.dto.DenunciaResponseDto;
import com.sosmt.service.denuncia.DenunciaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/denuncia")
public class DenunciaController {

	@Autowired
	private DenunciaService denunciaService;

	@Transactional
	@PostMapping
	public ResponseEntity registrarDenuncia(@RequestBody DenunciaRequest request, UriComponentsBuilder builder) {
		System.out.println(request.getIdUsuario());
		Denuncia denuncia = denunciaService.registrarDenuncia(request);
		URI uri = builder.path("/{id}").buildAndExpand(denuncia.getIdDenuncia()).toUri();
		return ResponseEntity.created(uri).body(new DenunciaResponseDto(denuncia));
	}

	@GetMapping
	public ResponseEntity obterTodasDenuncias() {
		List<Denuncia> denuncias = denunciaService.obterTodasDenuncias();
		List<DenunciaResponseDto> denunciaResponseDtoList = denuncias.stream().map(DenunciaResponseDto::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(denunciaResponseDtoList);
	}

	@GetMapping("/{id}")
	public ResponseEntity obterDenunciaPorId(@PathVariable("id") String idDenuncia) {
		Denuncia denuncia = denunciaService.obterDenunciaPorId(idDenuncia);
		return ResponseEntity.ok(new DenunciaResponseDto(denuncia));
	}

	@GetMapping("/byUser/{id}")
	public ResponseEntity obterDenunciasPorIdUsuario(@PathVariable("id") String idDenuncia) {
		List<Denuncia> denunciasPorIdUsuario = denunciaService.obterDenunciasPorUsuarioId(idDenuncia);
		List<DenunciaResponseDto> denunciaResponseDtoList = denunciasPorIdUsuario.stream().map(DenunciaResponseDto::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(denunciaResponseDtoList);
	}

}
