package com.sosmt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sosmt.model.usuario.Usuario;
import com.sosmt.model.usuario.dto.UsuarioLoginRequest;
import com.sosmt.model.usuario.dto.UsuarioRegisterRequest;

@Mapper
public interface UsuarioMapper {

	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	public Usuario usuarioLoginRequestToUsuario(UsuarioLoginRequest request);

	public Usuario usuarioRegisterRequestToUsuario(UsuarioRegisterRequest request);
}
