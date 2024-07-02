package com.sosmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sosmt.model.denuncia.Denuncia;

public interface DenunciaRepository extends JpaRepository<Denuncia, String> {

	List<Denuncia> findAllByUsuarioIdUsuario(String idUsuario);

}
