package br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem;

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
public class AgendamentoMensagemStatusOutputDTO implements Serializable {

	private static final long serialVersionUID = -4181339596768386714L;

	private Long id;

	private String status;

}
