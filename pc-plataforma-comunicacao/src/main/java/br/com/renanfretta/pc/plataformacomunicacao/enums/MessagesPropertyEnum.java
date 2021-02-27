package br.com.renanfretta.pc.plataformacomunicacao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesPropertyEnum {
	
	// Erros gerais
	ERRO__COMUNICACAO("erro.comunicacao"), //
	ERRO__REGISTRO_NAO_EXISTE("erro.registro-nao-existe"), //
	ERRO__INTEGRIDADE_BANCO_DADOS("erro.integridade-banco-dados"), //
	ERRO__EXISTEM_REGISTROS_DEPENDENTES("erro.existem-registros-dependentes"), //
	ERRO__DUPLICIDADE_BANCO_DADOS("erro.duplicidade-banco-dados"), //

	ERRO__REGISTRO_NAO_ENCONTRADO_ENTIDADE_AGENDAMENTO_MENSAGEM("erro.registro-nao-encontrado-entidade-agendamento-mensagem"), //
	ERRO__REGISTRO_NAO_ENCONTRADO_ENTIDADE_FORMATO_MENSAGEM("erro.registro-nao-encontrado-entidade-formato-mensagem"), //
	ERRO__REGISTRO_NAO_ENCONTRADO_ENTIDADE_PESSOA("erro.registro-nao-encontrado-entidade-pessoa");

	private String key;

}