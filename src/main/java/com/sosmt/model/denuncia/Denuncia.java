package com.sosmt.model.denuncia;

import java.time.LocalDateTime;

import com.sosmt.model.denuncia.dto.DenunciaRequest;
import com.sosmt.model.endereco.Endereco;
import com.sosmt.model.usuario.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idDenuncia")
@Table(name = "denuncia")
public class Denuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idDenuncia;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	private LocalDateTime horaDenuncia;
	private String descricaoDenuncia;

	public Denuncia(DenunciaRequest request, Usuario usuario) {
		this.idDenuncia = null;
		this.descricaoDenuncia = request.getDescricao();
		this.endereco = request.getEndereco();
		this.usuario = usuario;
		this.horaDenuncia = LocalDateTime.now();
	}

}
