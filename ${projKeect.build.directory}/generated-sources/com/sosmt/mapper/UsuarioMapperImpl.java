package com.sosmt.mapper;

import com.sosmt.model.usuario.Usuario;
import com.sosmt.model.usuario.dto.UsuarioLoginRequest;
import com.sosmt.model.usuario.dto.UsuarioRegisterRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-02T12:59:31-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 21.0.1 (Oracle Corporation)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario usuarioLoginRequestToUsuario(UsuarioLoginRequest request) {
        if ( request == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setEmail( request.getEmail() );
        usuario.setSenha( request.getSenha() );

        return usuario;
    }

    @Override
    public Usuario usuarioRegisterRequestToUsuario(UsuarioRegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setCpf( request.getCpf() );
        usuario.setDataNascimento( request.getDataNascimento() );
        usuario.setEmail( request.getEmail() );
        usuario.setEndereco( request.getEndereco() );
        usuario.setNomeUsuario( request.getNomeUsuario() );
        usuario.setPcd( request.isPcd() );
        usuario.setPermissao( request.getPermissao() );
        usuario.setSenha( request.getSenha() );

        return usuario;
    }
}
