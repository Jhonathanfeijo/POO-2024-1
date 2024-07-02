package com.sosmt.model.usuario.dto;

import lombok.Data;

@Data
public class UsuarioLoginRequest {

	private String email;
	private String senha;
}
