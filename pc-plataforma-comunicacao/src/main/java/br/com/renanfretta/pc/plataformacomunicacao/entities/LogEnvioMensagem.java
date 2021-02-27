package br.com.renanfretta.pc.plataformacomunicacao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity
public class LogEnvioMensagem implements Serializable {

	private static final long serialVersionUID = 5213329220605815010L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;

	@ManyToOne
	@JoinColumn(name = "id_agendamento_mensagem")
	private AgendamentoMensagem agendamentoMensagem;
	
	private String mensagemErro;
	
	private boolean enviada;

}
