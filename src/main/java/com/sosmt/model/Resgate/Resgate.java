package com.sosmt.model.Resgate;

import java.time.LocalDateTime;

import com.sosmt.model.endereco.Endereco;
import com.sosmt.model.provedorAjuda.ProvedorAjuda;
import com.sosmt.model.usuario.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idResgate")
public class Resgate {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idResgate;
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	@ManyToOne
	private ProvedorAjuda provedorAjuda;
	private LocalDateTime dataSolicitada;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Endereco endereco;
	private String descricao;
	
	public Resgate(Usuario usuario, ProvedorAjuda provedor, Endereco endereco, String descricao) {
		this.idResgate = null;
		this.usuario = usuario;
		this.provedorAjuda = provedor;
		this.endereco = endereco;
		this.dataSolicitada = LocalDateTime.now();
		this.descricao = descricao;
	}

}
