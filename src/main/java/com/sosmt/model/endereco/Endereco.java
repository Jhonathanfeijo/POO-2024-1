package com.sosmt.model.endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idEndereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idEndereco;
	@NotBlank
	private String rua;
	@NotBlank
	private String bairro;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	@NotBlank
	private String uf;

}
