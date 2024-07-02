package com.sosmt.modal.resgate.dto;

import com.sosmt.model.endereco.Endereco;

import lombok.Data;

@Data
public class ResgateRequest {

	private String idProvedor;
	private String idUsuario;
	private Endereco endereco;
	private String descricao;
}
