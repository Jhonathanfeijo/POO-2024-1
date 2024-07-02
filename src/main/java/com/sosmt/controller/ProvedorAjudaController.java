package com.sosmt.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sosmt.model.provedorAjuda.ProvedorAjuda;
import com.sosmt.model.provedorAjuda.dto.ProvedorAjudaRequest;
import com.sosmt.repositories.ProvedorAjudaRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/provAjud")
public class ProvedorAjudaController {

	@Autowired
	private ProvedorAjudaRepository provedorRepository;
	
	@Transactional
	@PostMapping
	public ResponseEntity criarProvedorAjuda(@RequestBody ProvedorAjudaRequest request, UriComponentsBuilder builder) {
		ProvedorAjuda provedorAjuda = new ProvedorAjuda(request);
		provedorAjuda = provedorRepository.save(provedorAjuda);
		URI uri = builder.path("/{id}").buildAndExpand(provedorAjuda.getId()).toUri();
		return ResponseEntity.created(uri).body(provedorAjuda);
	}

	@GetMapping
	public ResponseEntity obterProvedoresAjuda() {
		List<ProvedorAjuda> provedores = provedorRepository.findAll();
		return ResponseEntity.ok(provedores);
	}

	@GetMapping("/{id}")
	public ResponseEntity obterProvedorPorId(@PathVariable("id") String id) {
		ProvedorAjuda provedorAjuda = provedorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Provedor de ajuda não foi encontrado!"));
		return ResponseEntity.ok(provedorAjuda);
	}

	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity atualizarProvedorPorId(@PathVariable("id") String id,
			@RequestBody ProvedorAjudaRequest request) {
		if (!provedorRepository.existsById(id))
			throw new RuntimeException("Provedor de ajuda não foi encontrado");
		ProvedorAjuda provedorAjuda = new ProvedorAjuda(request);
		provedorAjuda.setId(id);
		return ResponseEntity.ok(provedorAjuda);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletarProvedorPorId(@PathVariable("id") String id) {
		if (!provedorRepository.existsById(id))
			throw new RuntimeException("Provedor de ajuda não foi encontrado");
		provedorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
