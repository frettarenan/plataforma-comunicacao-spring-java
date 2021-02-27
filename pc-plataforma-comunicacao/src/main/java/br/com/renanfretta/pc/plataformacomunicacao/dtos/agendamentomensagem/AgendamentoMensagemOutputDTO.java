package br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.renanfretta.pc.plataformacomunicacao.dtos.formatomensagem.FormatoMensagemOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.pessoa.PessoaOutputDTO;
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
public class AgendamentoMensagemOutputDTO implements Serializable {

	private static final long serialVersionUID = -4181339596768386714L;

	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date dataHora;

	private PessoaOutputDTO pessoaDestinatario;

	private FormatoMensagemOutputDTO formatoMensagem;

	private String mensagem;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dataHoraCancelamento;

	private boolean cancelado;

}
