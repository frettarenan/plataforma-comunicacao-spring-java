package br.com.renanfretta.pc.plataformacomunicacao.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.renanfretta.pc.plataformacomunicacao.configs.MessagesProperty;
import br.com.renanfretta.pc.plataformacomunicacao.configs.OrikaMapper;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.formatomensagem.FormatoMensagemOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.entities.FormatoMensagem;
import br.com.renanfretta.pc.plataformacomunicacao.enums.MessagesPropertyEnum;
import br.com.renanfretta.pc.plataformacomunicacao.exceptions.ErroTratadoRestException;
import br.com.renanfretta.pc.plataformacomunicacao.repositories.FormatoMensagemRepository;

@Service
@Validated
public class FormatoMensagemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FormatoMensagemService.class);

	@Autowired
	private OrikaMapper orikaMapper;

	@Autowired
	private MessagesProperty messagesProperty;

	@Autowired
	private FormatoMensagemRepository repository;

	public FormatoMensagemOutputDTO findById(Long id) throws ErroTratadoRestException {
		FormatoMensagem entity = repository.findById(id).orElseThrow(() -> new ErroTratadoRestException(messagesProperty.getMessage(MessagesPropertyEnum.ERRO__REGISTRO_NAO_ENCONTRADO_ENTIDADE_FORMATO_MENSAGEM)));
		LOGGER.trace("FormatoMensagemRepository/findById(" + id + ") teve êxito");
		FormatoMensagemOutputDTO dto = orikaMapper.map(entity, FormatoMensagemOutputDTO.class);
		return dto;
	}

}
