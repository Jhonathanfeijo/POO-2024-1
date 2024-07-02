package com.sosmt.modal.resgate.dto;

import com.sosmt.model.Resgate.Resgate;
import com.sosmt.model.endereco.Endereco;

import lombok.Data;

@Data
public class ResgateResponseDto {

	private String descricaoProvedor;
	private String nomeUsuario;
	private String cpfUsuario;
	private String telefoneUsuario;
	private String emailUsuario;
	private Endereco endereco;

	public ResgateResponseDto(Resgate resgate) {
		this.descricaoProvedor = resgate.getProvedorAjuda().getDescricao();
		this.nomeUsuario = resgate.getUsuario().getNomeUsuario();
		this.cpfUsuario = resgate.getUsuario().getCpf();
		this.telefoneUsuario = resgate.getUsuario().getTelefone();
		this.emailUsuario = resgate.getUsuario().getEmail();
		this.endereco = resgate.getUsuario().getEndereco();
	}

}
