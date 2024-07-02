package com.sosmt.model.denuncia.dto;

import com.sosmt.model.endereco.Endereco;

import lombok.Data;

@Data
public class DenunciaRequest {

	private String idUsuario;
	private String descricao;
	private Endereco endereco;
	
	
}
