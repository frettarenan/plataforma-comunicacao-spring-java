package br.com.renanfretta.pc.plataformacomunicacao.dtos.pessoa;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaOutputDTO implements Serializable {

	private static final long serialVersionUID = -4827749188391203009L;

	@EqualsAndHashCode.Include
	private Long id;

	private String nome;

	private String email;

	private String celular;

}
