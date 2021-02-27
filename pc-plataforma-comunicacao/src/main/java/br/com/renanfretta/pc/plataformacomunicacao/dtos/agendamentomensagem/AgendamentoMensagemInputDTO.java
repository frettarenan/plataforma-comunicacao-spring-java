package br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.renanfretta.pc.plataformacomunicacao.dtos.formatomensagem.FormatoMensagemOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.pessoa.PessoaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendamentoMensagemInputDTO implements Serializable {

	private static final long serialVersionUID = 8362162964799665614L;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date dataHora;
	
	private PessoaOutputDTO pessoaDestinatario;
	
	private FormatoMensagemOutputDTO formatoMensagem;
	
	private String mensagem;

}
