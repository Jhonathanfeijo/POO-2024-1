package com.sosmt.model.provedorAjuda;

import com.sosmt.model.provedorAjuda.dto.ProvedorAjudaRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProvedorAjuda {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String descricao;
	private String email;
	private String telefone;
	
	
	public ProvedorAjuda(ProvedorAjudaRequest request) {
		this.id = null;
		this.descricao = request.getDescricao();
		this.email = request.getEmail();
		this.telefone = request.getTelefone();
	}

}
