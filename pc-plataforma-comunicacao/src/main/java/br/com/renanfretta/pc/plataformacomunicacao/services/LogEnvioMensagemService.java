package br.com.renanfretta.pc.plataformacomunicacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.renanfretta.pc.plataformacomunicacao.repositories.logenviomensagem.LogEnvioMensagemRepository;

@Service
@Validated
public class LogEnvioMensagemService {

	@Autowired
	private LogEnvioMensagemRepository repository;

	public Long countMensagensEnviadasByIdAgendamentoMensagem(Long id) {
		return repository.countMensagensEnviadasByIdAgendamentoMensagem(id);
	}

}
