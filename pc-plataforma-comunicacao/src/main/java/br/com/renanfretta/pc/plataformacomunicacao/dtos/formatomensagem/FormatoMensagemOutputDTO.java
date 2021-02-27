package br.com.renanfretta.pc.plataformacomunicacao.dtos.formatomensagem;

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
public class FormatoMensagemOutputDTO implements Serializable {

	private static final long serialVersionUID = -1059692008881831063L;

	@EqualsAndHashCode.Include
	private Long id;

	private String nome;

}
