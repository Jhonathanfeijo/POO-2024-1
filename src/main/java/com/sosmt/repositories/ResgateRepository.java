package com.sosmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sosmt.model.Resgate.Resgate;

public interface ResgateRepository extends JpaRepository<Resgate, String> {

	List<Resgate> findAllByUsuarioIdUsuario(String idUsuario);
}
