package com.sosmt.model.usuario.dto;

import java.time.LocalDate;

import com.sosmt.model.endereco.Endereco;

import lombok.Data;

@Data
public class UsuarioRegisterRequest {

	private String nomeUsuario;
	private LocalDate dataNascimento;
	private String cpf;
	private String email;
	private String senha;
	private String permissao;
	private Endereco endereco;
	private boolean pcd;

}
