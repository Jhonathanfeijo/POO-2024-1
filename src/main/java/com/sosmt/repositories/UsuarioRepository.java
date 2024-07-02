package com.sosmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.sosmt.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	public boolean existsByCpf(String cpf);

	public boolean existsByEmail(String email);
	
	UserDetails findByEmail(String Email);

}
