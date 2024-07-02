package com.sosmt.model.denuncia.dto;

import com.sosmt.model.denuncia.Denuncia;
import com.sosmt.model.endereco.Endereco;

import lombok.Data;

@Data
public class DenunciaResponseDto {

	private String nomeUsuario;
	private String telefoneUsuario;
	private String cpfUsuario;
	private String emailUsuario;
	private String descricao;
	private Endereco endereco;

	public DenunciaResponseDto(Denuncia denuncia) {
		this.nomeUsuario = denuncia.getUsuario().getNomeUsuario();
		this.telefoneUsuario = denuncia.getUsuario().getTelefone();
		this.cpfUsuario = denuncia.getUsuario().getCpf();
		this.emailUsuario = denuncia.getUsuario().getEmail();
		this.descricao = denuncia.getDescricaoDenuncia();
		this.endereco = denuncia.getEndereco();
	}

}
