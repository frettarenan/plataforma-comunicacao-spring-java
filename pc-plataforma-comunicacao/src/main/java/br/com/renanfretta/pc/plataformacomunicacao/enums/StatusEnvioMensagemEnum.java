package br.com.renanfretta.pc.plataformacomunicacao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnvioMensagemEnum {

	AGENDADA("Agendada"), //
	ENVIADA("Enviada"), //
	ERRO_AO_ENVIAR("Erro ao enviar"), //
	CANCELADA("Cancelada"); //
	

	private String status;

}