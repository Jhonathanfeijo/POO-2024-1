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

import com.sosmt.modal.resgate.dto.ResgateRequest;
import com.sosmt.modal.resgate.dto.ResgateResponseDto;
import com.sosmt.model.Resgate.Resgate;
import com.sosmt.service.resgate.ResgateService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/resgate")
public class ResgateController {

	@Autowired
	private ResgateService resgateService;

	@Transactional
	@PostMapping
	public ResponseEntity registrarResgate(@RequestBody ResgateRequest request, UriComponentsBuilder builder) {
		Resgate resgate = resgateService.registrarResgate(request);
		URI uri = builder.path("/{id}").buildAndExpand(resgate.getIdResgate()).toUri();
		return ResponseEntity.created(uri).body(new ResgateResponseDto(resgate));
	}

	@GetMapping("/{id}")
	public ResponseEntity obterResgatePorId(@PathVariable("id") String idResgate) {
		Resgate resgate = resgateService.obterResgatePorId(idResgate);
		return ResponseEntity.ok(new ResgateResponseDto(resgate));
	}

	@GetMapping("/byUser/{id}")
	public ResponseEntity obterResgatePorUsuarioId(@PathVariable("id") String idUsuario) {
		List<Resgate> resgatesPorUsuarioId = resgateService.obterResgatesPorUsuarioId(idUsuario);
	    List<ResgateResponseDto> resgateResponseDtoList = resgatesPorUsuarioId.stream()
                .map(ResgateResponseDto::new)
                .collect(Collectors.toList());

		return ResponseEntity.ok(resgateResponseDtoList);
	}

	@GetMapping
	public ResponseEntity obterTodosResgates() {
		List<Resgate> resgates = resgateService.obterTodosResgates();
	    List<ResgateResponseDto> resgateResponseDtoList = resgates.stream()
                .map(ResgateResponseDto::new)
                .collect(Collectors.toList());

		return ResponseEntity.ok(resgateResponseDtoList);
	}

}
