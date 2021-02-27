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
public class AgendamentoMensagem implements Serializable {

	private static final long serialVersionUID = -977179956902614071L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa_destinatario")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "id_formato_mensagem")
	private FormatoMensagem formatoMensagem;
	
	private String mensagem;

}
