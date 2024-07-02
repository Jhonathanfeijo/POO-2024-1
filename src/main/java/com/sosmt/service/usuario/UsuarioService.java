package com.sosmt.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sosmt.mapper.UsuarioMapper;
import com.sosmt.model.usuario.Usuario;
import com.sosmt.model.usuario.dto.UsuarioLoginRequest;
import com.sosmt.model.usuario.dto.UsuarioRegisterRequest;
import com.sosmt.repositories.UsuarioRepository;
import com.sosmt.service.usuario.validadacao.ValidadorUsuario;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private List<ValidadorUsuario> validadores;

	@Autowired
	private PasswordEncoder encoder;

	public Usuario criarUsuario(Usuario request) {
		String senhaCriptografada = encoder.encode(request.getSenha());
		request.setSenha(senhaCriptografada);
		validadores.forEach(validador -> validador.validar(request));
		Usuario usuarioCriado = usuarioRepository.save(request);
		return usuarioCriado;
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return usuarioRepository.findByEmail(email);
	}

}
