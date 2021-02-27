package br.com.renanfretta.pc.plataformacomunicacao.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.renanfretta.pc.plataformacomunicacao.configs.MessagesProperty;
import br.com.renanfretta.pc.plataformacomunicacao.configs.OrikaMapper;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.pessoa.PessoaOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.entities.Pessoa;
import br.com.renanfretta.pc.plataformacomunicacao.enums.MessagesPropertyEnum;
import br.com.renanfretta.pc.plataformacomunicacao.exceptions.ErroTratadoRestException;
import br.com.renanfretta.pc.plataformacomunicacao.repositories.PessoaRepository;

@Service
@Validated
public class PessoaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PessoaService.class);

	@Autowired
	private OrikaMapper orikaMapper;

	@Autowired
	private MessagesProperty messagesProperty;

	@Autowired
	private PessoaRepository repository;

	public PessoaOutputDTO findById(Long id) throws ErroTratadoRestException {
		Pessoa entity = repository.findById(id).orElseThrow(() -> new ErroTratadoRestException(messagesProperty.getMessage(MessagesPropertyEnum.ERRO__REGISTRO_NAO_ENCONTRADO_ENTIDADE_PESSOA)));
		LOGGER.trace("PessoaRepository/findById(" + id + ") teve êxito");
		PessoaOutputDTO dto = orikaMapper.map(entity, PessoaOutputDTO.class);
		return dto;
	}

}
